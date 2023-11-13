package com.example.OurHome.service;

import com.example.OurHome.model.Entity.Property;
import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.UserEntity;

public interface MessageService {
    void sendRegistrationMessageToUser(UserEntity newUserEntity);

    void deleteMessage(Long id);

    void sendRegistrationMessageToManager(ResidentialEntity residentialEntity);

    void readMessage(Long id);

    void archiveMessage(Long id);

    void newModeratorMessage(UserEntity userEntity, ResidentialEntity residentialEntity);

    void propertyApprovedMessage(Property property, UserEntity userEntity, ResidentialEntity residentialEntity);
    void propertyRejectedMessage(Property property, UserEntity userEntity, ResidentialEntity residentialEntity);
    void propertyDeletedMessage(Property property, UserEntity userEntity, ResidentialEntity residentialEntity);
}
