package com.test.TestVagrant.TestVagrant_java;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
    private String location;
    private List<Players> player = new ArrayList<Players>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Players> getPlayer() {
        return player;
    }
    public void setPlayer(List<Players> player) {
        this.player = player;
    }

}
