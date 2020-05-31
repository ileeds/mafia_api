package com.mafia.db.stored.play.impl;

import com.mafia.db.stored.play.Player;

import javax.persistence.Entity;

@Entity
public class StoredPlayerImpl implements Player {
    private String id;

    @Override
    public String getId() {
        return id;
    }
}
