package com.felipe.notification_service.controller;

import com.felipe.notification_service.dto.NotificationDTO;
import com.felipe.notification_service.model.Notification;
import com.felipe.notification_service.model.Notification.NotificationStatus;
import com.felipe.notification_service.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> findAll() {
        return ResponseEntity.ok(notificationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> findById(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.findById(id));
    }

    @GetMapping("/recipient/{recipient}")
    public ResponseEntity<List<Notification>> findByRecipient(@PathVariable String recipient) {
        return ResponseEntity.ok(notificationService.findByRecipient(recipient));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Notification>> findByStatus(@PathVariable NotificationStatus status) {
        return ResponseEntity.ok(notificationService.findByStatus(status));
    }

    @PostMapping("/send")
    public ResponseEntity<Notification> send(@Valid @RequestBody NotificationDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.send(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notificationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}