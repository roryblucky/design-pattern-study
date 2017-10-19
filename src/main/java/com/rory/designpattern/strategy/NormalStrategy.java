package com.rory.designpattern.strategy;

public class NormalStrategy implements IStrategy {
    @Override
    public void apply(String user) {
        System.out.println("normal strategy execute to user" + user);
    }
}
