package com.felipe.notification_service.dto;

import com.felipe.notification_service.model.Notification.NotificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationDTO {

    @NotBlank(message = "Destinatário é obrigatório")
    private String recipient;

    @NotBlank(message = "Assunto é obrigatório")
    private String subject;

    @NotBlank(message = "Mensagem é obrigatória")
    private String message;

    @NotNull(message = "Tipo é obrigatório")
    private NotificationType type;
}