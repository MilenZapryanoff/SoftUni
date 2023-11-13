package com.example.OurHome.service.impl;

import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.ResidentialEntityEditBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.ResidentialEntityRegisterBindingModel;
import com.example.OurHome.repo.CityRepository;
import com.example.OurHome.repo.ResidentialEntityRepository;
import com.example.OurHome.service.ResidentialEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ResidentialEntityServiceImpl implements ResidentialEntityService {

    private final ModelMapper modelMapper;
    private final CityRepository cityRepository;
    private final ResidentialEntityRepository residentialEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public ResidentialEntityServiceImpl(ModelMapper modelMapper, CityRepository cityRepository, ResidentialEntityRepository residentialEntityRepository, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.cityRepository = cityRepository;
        this.residentialEntityRepository = residentialEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * New Residential entity creation method.
     *
     * @return boolean
     */
    @Override
    public boolean newResidentialEntity(ResidentialEntityRegisterBindingModel residentialEntityRegisterBindingModel, UserEntity loggedUser) {

        ResidentialEntity newResidentialEntity = modelMapper.map(residentialEntityRegisterBindingModel, ResidentialEntity.class);

        newResidentialEntity.setManager(loggedUser);
        newResidentialEntity.setCity(cityRepository.findByName(residentialEntityRegisterBindingModel.getCity()));

        //generating a random 8-digit code user as residentialEntity ID
        Long generatedRandomId = new Random().nextLong(9999999, 100000000);
        newResidentialEntity.setId(generatedRandomId);

        //creation of access code hint
        String accessCode = residentialEntityRegisterBindingModel.getAccessCode();
        newResidentialEntity.setAccessCode(passwordEncoder.encode(accessCode));
        newResidentialEntity.setAccessCodeHint(createAccessCodeHint(accessCode));

        residentialEntityRepository.save(newResidentialEntity);

        return residentialEntityRepository.countById(generatedRandomId) != 0;
    }

    @Override
    public void removeResidentialEntity(Long id) {
        residentialEntityRepository.deleteById(id);
    }

    @Override
    public boolean checkIfResidentialEntityDeletable(Long id) {
        ResidentialEntity residentialEntity = residentialEntityRepository.findResidentialEntityById(id);
        return residentialEntity.getResidents().isEmpty();
    }

    @Override
    public boolean accessCodesMatchCheck(String accessCode, String confirmAccessCode) {
        return accessCode.equals(confirmAccessCode);
    }

    @Override
    public Optional<ResidentialEntity> findResidentialEntityById(Long id) {
        return residentialEntityRepository.findById(id);
    }

    @Override
    public void editResidentialEntity(Long entityId, ResidentialEntityEditBindingModel residentialEntityEditBindingModel) {

        ResidentialEntity residentialEntity = residentialEntityRepository.findById(entityId).orElse(null);

        if (residentialEntity != null) {
            String accessCode = residentialEntityEditBindingModel.getAccessCode();

            residentialEntity.setCity(cityRepository.findByName(residentialEntityEditBindingModel.getCity()));
            residentialEntity.setStreetName(residentialEntityEditBindingModel.getStreetName());
            residentialEntity.setStreetNumber(residentialEntityEditBindingModel.getStreetNumber());
            residentialEntity.setEntrance(residentialEntityEditBindingModel.getEntrance());
            residentialEntity.setNumberOfApartments(residentialEntityEditBindingModel.getNumberOfApartments());

            if (accessCode.length() >= 3) {
                residentialEntity.setAccessCode(passwordEncoder.encode(accessCode));
                residentialEntity.setAccessCodeHint(createAccessCodeHint(accessCode));
            }
            residentialEntityRepository.save(residentialEntity);
        }






    }

    /**
     * Access code hint creation method
     *
     * @return String
     */
    private String createAccessCodeHint(String accessCode) {
        int passwordHintLength = accessCode.length();
        return accessCode.substring(0, 2) +
                "*".repeat(passwordHintLength - 3) +
                accessCode.substring(passwordHintLength - 1);
    }
}
