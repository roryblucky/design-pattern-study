package com.rory.designpattern.decorator;

public class Noodle extends Foods {

    public Noodle() {
        super("Noodle");
    }

    @Override
    public void cook() {
        System.out.println("cook noodles");
    }
}
