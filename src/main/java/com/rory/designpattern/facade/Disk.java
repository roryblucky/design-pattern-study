package com.rory.designpattern.facade;

public class Disk implements IStartAction {
    @Override
    public void start() {
        System.out.println("Disk Start");
    }
}
