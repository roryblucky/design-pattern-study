package com.rory.designpattern.facade;

public class CPU implements IStartAction {
    @Override
    public void start() {
        System.out.println("CPU Start");
    }
}
