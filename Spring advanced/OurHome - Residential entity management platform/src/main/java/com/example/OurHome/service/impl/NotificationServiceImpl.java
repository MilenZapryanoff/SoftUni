package com.example.OurHome.service.impl;

import com.example.OurHome.model.Entity.Notification;
import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.repo.NotificationRepository;
import com.example.OurHome.service.NotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void addRegistrationNotification(UserEntity userEntity) {
        notificationRepository.save(
                new Notification(
                LocalDate.now(),
                "Thanks for your registration! Your profile is still not Verified!" +
                        " As soon as Your Residential entity manager confirms your registration " +
                        "your profile will get Verified and You will be able to access your property details!",
                userEntity,
                false));
    }

    @Override
    public void removeNotification(Long id) {
        notificationRepository.deleteById(id);
    }


}
