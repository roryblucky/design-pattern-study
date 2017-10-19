package com.rory.designpattern.observer.usejdk;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof House) {
            System.out.println(this.name);
        }
    }
}
