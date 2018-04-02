package com.rory.designpattern.observer.custom;

public class Observer1 implements IObserver {
    @Override
    public void update() {
        System.out.println("Observer1 is notified.");
    }
}
