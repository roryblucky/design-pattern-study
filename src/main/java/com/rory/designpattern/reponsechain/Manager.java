package com.rory.designpattern.reponsechain;

public abstract class Manager {
    protected String name;

    protected Manager manager;

    public Manager(String name) {
        this.name = name;
    }

    public Manager setManager(Manager manager) {
        this.manager = manager;
        return manager;
    }

    public abstract boolean isSupport(int days);

    public void askForLeave(int days) {
        if (this.isSupport(days)) {
            System.out.println(this.name + "同意");
        } else {
            System.out.println(this.name + ": 无权限");
            this.manager.askForLeave(days);
        }
    }
}
