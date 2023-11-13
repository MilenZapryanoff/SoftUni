package com.example.OurHome.service.impl;

import com.example.OurHome.model.Entity.Message;
import com.example.OurHome.model.Entity.Property;
import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.repo.MessageRepository;
import com.example.OurHome.service.MessageService;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;

    }

    /**
     * This method sends a welcome message of each new user.
     */
    @Override
    public void sendRegistrationMessageToUser(UserEntity userEntity) {
        messageRepository.save(
                new Message(
                        LocalDate.now(),
                        Time.valueOf(LocalTime.now()),
                        "Thanks for your registration! To access your residential entity data you should first" +
                                " add a property. After your residential entity manager verifies your request " +
                                "you will get full access.",
                        userEntity,
                        false,
                        false));
    }

    /**
     * This method sends a message to the manager of the Residential entity when new registration of resident
     * happens.
     */
    @Override
    public void sendRegistrationMessageToManager(ResidentialEntity residentialEntity) {
        messageRepository.save(
                new Message(
                        LocalDate.now(),
                        Time.valueOf(LocalTime.now()),
                        "New property registration in Residential entity ID: "
                                + residentialEntity.getId() + ". You can access the request via Administration panel",
                        residentialEntity.getManager(),
                        false,
                        false));
    }

    /**
     * This method sends a message to the user, when his role has been changed to Moderator of a Residential entity.
     */
    @Override
    public void newModeratorMessage(UserEntity userEntity, ResidentialEntity residentialEntity) {
        messageRepository.save(
                new Message(
                        LocalDate.now(),
                        Time.valueOf(LocalTime.now()),
                        "You have been promoted as Moderator of Residential entity ID: "
                                + residentialEntity.getId() + ". You can access all the data related to this Residential entity via the Administration section",
                        userEntity,
                        false,
                        false));
    }

    /**
     * This method creates a message to the owner, when his apartment registration request is approved
     * by the Residential entity Manager.
     */
    @Override
    public void propertyApprovedMessage(Property property, UserEntity userEntity, ResidentialEntity residentialEntity) {
        messageRepository.save(
                new Message(
                        LocalDate.now(),
                        Time.valueOf(LocalTime.now()),
                        "Your registration request for property № " + property.getNumber() + " id Residential entity ID: "
                                + residentialEntity.getId() + " has been APPROVED. You can now access your data and reports.",
                        userEntity,
                        false,
                        false));
    }

    /**
     * This method creates a message to the owner, when his apartment registration request is rejected
     * by the Residential entity Manager.
     */
    @Override
    public void propertyRejectedMessage(Property property, UserEntity userEntity, ResidentialEntity residentialEntity) {
        messageRepository.save(
                new Message(
                        LocalDate.now(),
                        Time.valueOf(LocalTime.now()),
                        "Your registration request for property № " + property.getNumber() + " id Residential entity ID: "
                                + residentialEntity.getId() + " has been REJECTED. You can contact your Residential entity manager for more details " +
                                "about the reason for this action. If you still have an access to the Residential entity, You can edit the record and submit " +
                                "it again.",
                        userEntity,
                        false,
                        false));
    }

    /**
     * This method creates a message to the owner, when his apartment is deleted from Residential entity.
     */
    @Override
    public void propertyDeletedMessage(Property property, UserEntity userEntity, ResidentialEntity residentialEntity) {
        messageRepository.save(
                new Message(
                        LocalDate.now(),
                        Time.valueOf(LocalTime.now()),
                        "Your property № " + property.getNumber() + " has been REMOVED from Residential entity ID: "
                                + residentialEntity.getId() + ". You can contact your Residential entity manager for more details " +
                                "about the reason for this action. If you still have an access to the Residential entity, You can submit new " +
                                "property registration request.",
                        userEntity,
                        false,
                        false));
    }

    /**
     * Mark message as read method
     *
     * @param id
     */
    @Override
    public void readMessage(Long id) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message != null) {
            message.setRead(true);
            messageRepository.save(message);
        }
    }

    /**
     * Archive message method
     *
     * @param id
     */
    @Override
    public void archiveMessage(Long id) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message != null) {
            message.setArchived(true);
            message.setRead(true);
            messageRepository.save(message);
        }
    }

    /**
     * Delete message method
     *
     * @param id
     */
    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
