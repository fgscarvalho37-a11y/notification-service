package com.felipe.notification_service.repository;

import com.felipe.notification_service.model.Notification;
import com.felipe.notification_service.model.Notification.NotificationStatus;
import com.felipe.notification_service.model.Notification.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipient(String recipient);
    List<Notification> findByStatus(NotificationStatus status);
    List<Notification> findByType(NotificationType type);
}