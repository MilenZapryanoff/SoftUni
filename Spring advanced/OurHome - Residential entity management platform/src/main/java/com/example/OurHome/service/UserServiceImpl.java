package com.example.OurHome.service;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.ManagerRegisterBindingModel;
import com.example.OurHome.model.Entity.dto.UserBindingModel;
import com.example.OurHome.model.Entity.dto.UserRegisterBindingModel;
import com.example.OurHome.model.Entity.enums.UserRole;
import com.example.OurHome.repo.ResidentialEntityRepository;
import com.example.OurHome.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserRegToken userRegToken;
    private final ResidentialEntityRepository residentialEntityRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserRepository userRepository, UserRegToken userRegToken, ResidentialEntityRepository residentialEntityRepository) {
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userRegToken = userRegToken;
        this.residentialEntityRepository = residentialEntityRepository;
    }

    /**
     * PRE-REGISTRATION:
     * password match check
     */
    @Override
    public boolean preRegistrationPasswordMatchCheck(String password, String confirmPassword) {
        return password
                .equals(confirmPassword);
    }

    /**
     * PRE-REGISTRATION:
     * email duplicate check
     */

    @Override
    public boolean preRegistrationEmailCheck(String email) {
        UserEntity checkEmail = userRepository.findByEmail(email);
        return checkEmail == null;
    }

    /**
     * PRE-REGISTRATION:
     * username duplicate check
     */
    @Override
    public boolean preRegistrationUserCheck(String username) {
        Optional<UserEntity> checkUser = userRepository.findByUsername(username);
        return checkUser.isEmpty();
    }

    /**
     * USER REGISTRATION implementation
     */
    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel, Long residentialEntityId) {

        UserEntity newUserEntity = modelMapper.map(userRegisterBindingModel, UserEntity.class);
        newUserEntity.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        newUserEntity.setResidentialEntity(residentialEntityRepository.findById(residentialEntityId).orElse(null));
        newUserEntity.setRole(UserRole.USER);
        userRepository.save(newUserEntity);

        invalidateToken();
    }

    /**
     * MANAGER REGISTRATION implementation
     */
    @Override
    public void registerManager(ManagerRegisterBindingModel managerRegisterBindingModel) {

        UserEntity newManager = modelMapper.map(managerRegisterBindingModel, UserEntity.class);
        newManager.setPassword(passwordEncoder.encode(managerRegisterBindingModel.getPassword()));
        newManager.setValidated(true);
        newManager.setRole(UserRole.MANAGER);

        userRepository.save(newManager);
    }

    @Override
    public boolean residentialIdValidation(Long residentialId) {
        return residentialEntityRepository.countById(residentialId) > 0;
    }

    @Override
    public UserBindingModel getUserViewData(UserEntity loggedUser) {
        return modelMapper.map(loggedUser, UserBindingModel.class);
    }

    private void invalidateToken() {
        userRegToken.setTokenId(null);
        userRegToken.setValid(false);
    }
}
