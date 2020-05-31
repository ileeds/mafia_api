package com.mafia.db.stored.play.impl;

import com.mafia.db.stored.play.Game;

import javax.persistence.Entity;

@Entity
public class StoredGameImpl implements Game {
    private String id;

    @Override
    public String getId() {
        return id;
    }
}
