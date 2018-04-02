package com.rory.designpattern.observer.custom;

public class Observer2 implements IObserver {
    @Override
    public void update() {
        System.out.println("Observer2 is notified");
    }
}
