package com.example.OurHome.service.impl;

import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.ManagerRegisterBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.UserAuthBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.UserRegisterBindingModel;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.repo.ResidentialEntityRepository;
import com.example.OurHome.repo.RoleRepository;
import com.example.OurHome.repo.UserRepository;
import com.example.OurHome.service.MessageService;
import com.example.OurHome.service.UserService;
import com.example.OurHome.service.tokens.ResidentialEntityToken;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ResidentialEntityToken residentialEntityToken;
    private final ResidentialEntityRepository residentialEntityRepository;
    private final RoleRepository roleRepository;
    private final MessageService messageService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserRepository userRepository, ResidentialEntityToken residentialEntityToken, ResidentialEntityRepository residentialEntityRepository, RoleRepository roleRepository, MessageService messageService) {
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.residentialEntityToken = residentialEntityToken;
        this.residentialEntityRepository = residentialEntityRepository;
        this.roleRepository = roleRepository;
        this.messageService = messageService;
    }

    /**
     * PRE-REGISTRATION:
     * password match check
     *
     * @return boolean
     */
    @Override
    public boolean preRegistrationPasswordMatchCheck(String password, String confirmPassword) {
        return !password.equals(confirmPassword);
    }

    /**
     * PRE-REGISTRATION:
     * email duplicate check
     *
     * @return boolean
     */

    @Override
    public boolean preRegistrationEmailCheck(String email) {
        UserEntity checkEmail = userRepository.findByEmail(email).orElse(null);
        return checkEmail != null;
    }

    /**
     * PRE-REGISTRATION:
     * username duplicate check
     *
     * @return boolean
     */

    @Override
    public boolean preRegistrationUserCheck(String username) {
        UserEntity checkUser = userRepository.findByUsername(username).orElse(null);
        return checkUser != null;
    }

    /**
     * RESIDENT REGISTRATION implementation
     */
    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel, Long residentialEntityId) {
        ResidentialEntity residentialEntity = residentialEntityRepository.findById(residentialEntityId).orElse(null);

        UserEntity newUserEntity = modelMapper.map(userRegisterBindingModel, UserEntity.class);
        newUserEntity.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        newUserEntity.getResidentialEntities().add(residentialEntity);
        newUserEntity.setRole(roleRepository.findRoleByName("RESIDENT"));

        userRepository.save(newUserEntity);

        //sending a Welcome message to user
        messageService.sendRegistrationMessageToUser(newUserEntity);

        invalidateResidentialEntityToken();
    }

    /**
     * MANAGER REGISTRATION implementation
     */
    @Override
    public void registerManager(ManagerRegisterBindingModel managerRegisterBindingModel) {

        UserEntity newManager = modelMapper.map(managerRegisterBindingModel, UserEntity.class);
        newManager.setPassword(passwordEncoder.encode(managerRegisterBindingModel.getPassword()));
        newManager.setValidated(true);
        newManager.setRole(roleRepository.findRoleByName("MANAGER"));

        userRepository.save(newManager);
    }

    /**
     * Method for checking residential entity id and access code, when accessing a new residential entity. .
     *
     * @return : boolean
     */
    @Override
    public boolean residentialValidation(Long residentialId, String accessCode) {
        ResidentialEntity residentialEntity = residentialEntityRepository.findResidentialEntityById(residentialId);

        return residentialEntityRepository.countById(residentialId) > 0 &&
                passwordEncoder.matches(accessCode, residentialEntity.getAccessCode());
    }

    /**
     * UserViewModel initialization method.
     *
     * @return : UserViewModel
     */
    @Override
    public UserViewModel getUserViewData(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserViewModel.class);
    }

    /**
     * method : Find UserEntity by email
     *
     * @return : UserEntity
     */

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    /**
     * This method gives the user MODERATOR rights in residential entities.
     */
    @Override
    public void createModerator(Long residentId, Long entityId) {
        UserEntity userEntity = userRepository.findById(residentId).orElse(null);
        ResidentialEntity residentialEntity = residentialEntityRepository.findById(entityId).orElse(null);

        if (residentialEntity != null && userEntity != null) {
            userEntity.getModeratedResidentialEntities().add(residentialEntity);
            userRepository.save(userEntity);
            messageService.newModeratorMessage(userEntity, residentialEntity);
        }
    }


    /**
     * This method removes the user MODERATOR rights in residential entities.
     */
    @Override
    public void removeModerator(Long residentId, Long entityId) {
        UserEntity userEntity = userRepository.findById(residentId).orElse(null);
        ResidentialEntity residentialEntity = residentialEntityRepository.findById(entityId).orElse(null);

        if (residentialEntity != null && userEntity != null) {
            List<ResidentialEntity> moderatedEntities = userEntity.getModeratedResidentialEntities();

            // Iterate through the list and remove the entity with the matching ID
            Iterator<ResidentialEntity> iterator = moderatedEntities.iterator();
            while (iterator.hasNext()) {
                ResidentialEntity entity = iterator.next();
                if (entity.getId().equals(entityId)) {
                    iterator.remove();
                    break; // Assuming IDs are unique, no need to continue the loop
                }
            }
            userRepository.save(userEntity);
        }
    }

    /**
     * Method for joining user to new Residential entity.
     */
    @Override
    public void joinUserToNewResidentialEntity(UserAuthBindingModel userAuthBindingModel, UserEntity loggedUser) {

        ResidentialEntity newResidentialEntity = residentialEntityRepository.findById(Long.valueOf(userAuthBindingModel.getResidentialId())).orElse(null);

        if (newResidentialEntity != null) {
            //Check if this residential entity already preset for this user
            List<ResidentialEntity> userResidentialEntities = loggedUser.getResidentialEntities();
            for (ResidentialEntity residentialEntityList : userResidentialEntities) {
                if (residentialEntityList.getId().equals(newResidentialEntity.getId())) {
                    return;
                }
            }
            loggedUser.getResidentialEntities().add(newResidentialEntity);
            userRepository.save(loggedUser);
        }
    }

    /**
     * Token invalidation method.
     * When registering as a resident the user have to provide valid ResidentialEntity ID.
     * It is an 8-digit randomly generated code used as residential entity id in the DB.
     * The ID is used as registration token in UserRegToken class which gets invalidated after
     * registration.
     */

    private void invalidateResidentialEntityToken() {
        residentialEntityToken.setValid(false);
    }
}


