package com.rory.designpattern.reponsechain;

public class TeamLeader extends Manager {

    public TeamLeader() {
        super("TeamLeader");
    }

    @Override
    public boolean isSupport(int days) {
        return days > 1 && days < 3;
    }
}
