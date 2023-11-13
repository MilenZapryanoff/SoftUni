package com.example.OurHome.repo;

import com.example.OurHome.model.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Long countByUser_Id(Long id);

    @Query("SELECT COUNT(n) FROM notifications n where n.isRead = false AND n.user.id=:id")
    Long countUnreadNotifications(Long id);

}
