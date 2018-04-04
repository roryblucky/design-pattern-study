package com.rory.designpattern.reponsechain;

public class ProjectLeader extends Manager {

    public ProjectLeader() {
        super("ProjectLeader");
    }

    @Override
    public boolean isSupport(int days) {
        return days <= 1;
    }
}
