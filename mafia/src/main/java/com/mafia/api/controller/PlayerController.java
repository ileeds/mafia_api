package com.mafia.api.controller;

import com.mafia.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(Constants.PLAYER_CONTROLLER_PATH)
public class PlayerController {

    private SimpMessagingTemplate template;

    @Autowired
    public PlayerController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/registration")
    public void handle(String registration) {
        var text = "[" + new Date() + ": " + registration;
        this.template.convertAndSend("/topic/registration", text);
    }
}
