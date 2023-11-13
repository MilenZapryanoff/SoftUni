package com.example.OurHome.service;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.PropertyRegisterBindingModel;

public interface PropertyService {
    void newProperty(PropertyRegisterBindingModel propertyRegisterBindingModel, UserEntity loggedUser);

    void deleteProperty(Long id);

    void approveProperty(Long id);

    void rejectProperty(Long id);

}
