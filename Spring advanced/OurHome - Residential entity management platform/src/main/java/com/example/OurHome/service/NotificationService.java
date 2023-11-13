package com.example.OurHome.service;

import com.example.OurHome.model.Entity.Notification;
import com.example.OurHome.model.Entity.UserEntity;

import java.util.List;

public interface NotificationService {
    void addRegistrationNotification(UserEntity newUserEntity);

    void removeNotification(Long id);
}
