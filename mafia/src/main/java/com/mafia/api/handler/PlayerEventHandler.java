package com.mafia.api.handler;

import com.mafia.db.stored.play.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import static com.mafia.api.configuration.WebSocketConfiguration.MESSAGE_PREFIX;

@Component
@RepositoryEventHandler
public class PlayerEventHandler {

    private final SimpMessagingTemplate websocket;

    private final EntityLinks entityLinks;

    @Autowired
    public PlayerEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
        this.websocket = websocket;
        this.entityLinks = entityLinks;
    }

    @HandleAfterCreate
    public void newPlayer(Player player) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/newPlayer", getPath(player));
    }

    @HandleAfterDelete
    public void deletePlayer(Player player) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/deletePlayer", getPath(player));
    }

    @HandleAfterSave
    public void updatePlayer(Player player) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/updatePlayer", getPath(player));
    }

    /**
     * Take a {@link Player} and get the URI using Spring Data REST's {@link EntityLinks}.
     *
     * @param player {@link Player}
     */
    private String getPath(Player player) {
        return this.entityLinks.linkForItemResource(player.getClass(),
                player.getId()).toUri().getPath();
    }
}
