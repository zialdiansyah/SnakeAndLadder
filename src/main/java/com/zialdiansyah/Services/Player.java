package com.zialdiansyah.Services;

public class Player {
    private String name;

    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

}