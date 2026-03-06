package com.studentsos.studentsos.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void broadcastSOS(String studentName, String item, String location) {

        String message =
                "SOS ALERT\n" +
                        "Student: " + studentName + "\n" +
                        "Item Needed: " + item + "\n" +
                        "Location: " + location;

        messagingTemplate.convertAndSend("/topic/sos", message);
    }
}