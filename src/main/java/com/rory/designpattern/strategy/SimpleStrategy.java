package com.rory.designpattern.strategy;

public class SimpleStrategy implements IStrategy {
    @Override
    public void apply(String user) {
        System.out.println("simple strategy execute to user");
    }
}
