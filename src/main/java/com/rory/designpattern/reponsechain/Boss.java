package com.rory.designpattern.reponsechain;

public class Boss extends Manager {

    public Boss() {
        super("BOSS");
    }

    @Override
    public boolean isSupport(int days) {
        return days >= 3;
    }
}
