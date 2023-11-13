package com.example.OurHome.repo;

import com.example.OurHome.model.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Long countByUser_Id(Long id);

    Optional<Message> findById(Long id);

    @Query("SELECT COUNT(m) FROM messages m where m.isRead = false AND m.user.id=:id")
    Long countUnreadMessages(Long id);

    @Query("SELECT COUNT(m) FROM messages m where m.isArchived = false AND m.user.id=:id")
    Long countNotArchivedMessages(Long id);

    @Query("SELECT COUNT(m) FROM messages m where m.isArchived = true AND m.user.id=:id")
    Long countArchivedMessages(Long id);

    @Query("SELECT m FROM messages m where m.isArchived = true AND m.user.id=:id ORDER BY m.date, m.time DESC")
    List<Message> findArchivedMessagesById(Long id);

    @Query("SELECT m FROM messages m where m.isArchived = false AND m.user.id=:id ORDER BY m.date, m.time DESC")
    List<Message> findNotArchivedMessagesById(Long id);
}
