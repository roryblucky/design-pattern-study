package com.rory.designpattern.observer.custom;

public class CustomPerson implements CustomObserver {
    private String name;

    public CustomPerson(String name) {
        this.name = name;
    }

    @Override
    public void change(Object o) {
        System.out.println(o);
    }
}
