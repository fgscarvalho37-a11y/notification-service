package com.felipe.notification_service.service;

import com.felipe.notification_service.dto.NotificationDTO;
import com.felipe.notification_service.model.Notification;
import com.felipe.notification_service.model.Notification.NotificationStatus;
import com.felipe.notification_service.model.Notification.NotificationType;
import com.felipe.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public Notification findById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada com id: " + id));
    }

    public List<Notification> findByRecipient(String recipient) {
        return notificationRepository.findByRecipient(recipient);
    }

    public List<Notification> findByStatus(NotificationStatus status) {
        return notificationRepository.findByStatus(status);
    }

    public Notification send(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setRecipient(dto.getRecipient());
        notification.setSubject(dto.getSubject());
        notification.setMessage(dto.getMessage());
        notification.setType(dto.getType());
        notification.setStatus(NotificationStatus.SENT);
        notification.setSentAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public void delete(Long id) {
        findById(id);
        notificationRepository.deleteById(id);
    }
}