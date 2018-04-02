package com.rory.designpattern.facade;

public class Memory implements IStartAction {
    @Override
    public void start() {
        System.out.println("Memory start");
    }
}
