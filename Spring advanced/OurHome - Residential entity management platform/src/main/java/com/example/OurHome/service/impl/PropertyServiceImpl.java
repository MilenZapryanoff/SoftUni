package com.example.OurHome.service.impl;

import com.example.OurHome.model.Entity.Property;
import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.PropertyRegisterBindingModel;
import com.example.OurHome.repo.PropertyRepository;
import com.example.OurHome.service.MessageService;
import com.example.OurHome.service.PropertyService;
import com.example.OurHome.service.ResidentialEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final ModelMapper modelMapper;
    private final ResidentialEntityService residentialEntityService;
    private final PropertyRepository propertyRepository;
    private final MessageService messageService;


    public PropertyServiceImpl(ModelMapper modelMapper, ResidentialEntityService residentialEntityService, PropertyRepository propertyRepository, MessageService messageService) {
        this.modelMapper = modelMapper;
        this.residentialEntityService = residentialEntityService;
        this.propertyRepository = propertyRepository;
        this.messageService = messageService;
    }

    /**
     * Property creation method
     * Performed by USER
     */
    @Override
    public void newProperty(PropertyRegisterBindingModel propertyRegisterBindingModel, UserEntity loggedUser) {

        Property newProperty = modelMapper.map(propertyRegisterBindingModel, Property.class);
        Long residentialEntityId = propertyRegisterBindingModel.getResidentialEntity();

        ResidentialEntity residentialEntity = residentialEntityService
                .findResidentialEntityById(residentialEntityId)
                .orElse(null);

        newProperty.setResidentialEntity(residentialEntity);
        newProperty.setOwner(loggedUser);
        newProperty.setValidated(false);

        propertyRepository.save(newProperty);

        //sending message to residential entity manager
        messageService.sendRegistrationMessageToManager(residentialEntity);
    }


    /**
     * Property deletion method
     * Performed by USER or MANAGER
     */
    public void deleteProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            propertyRepository.delete(property);

            messageService.propertyDeletedMessage(property, property.getOwner(), property.getResidentialEntity());
        }
    }


    /**
     * Property approval method.
     * Performed by Residential entity MANAGER
     */
    @Override
    public void approveProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setValidated(true);
            propertyRepository.save(property);

            messageService.propertyApprovedMessage(property, property.getOwner(), property.getResidentialEntity());
        }
    }

    /**
     * Property reject method.
     * Performed by Residential entity MANAGER
     */
    @Override
    public void rejectProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setRejected(true);
            propertyRepository.save(property);

            messageService.propertyRejectedMessage(property, property.getOwner(), property.getResidentialEntity());
        }
    }
}
