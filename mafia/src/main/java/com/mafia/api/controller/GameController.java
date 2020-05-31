package com.mafia.api.controller;

import com.mafia.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(Constants.GAME_CONTROLLER_PATH)
public class GameController {

    private SimpMessagingTemplate template;

    @Autowired
    public GameController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/greeting")
    public String handle(String greeting) {
        return "[" + new Date() + ": " + greeting;
    }
}
