package com.rory.designpattern.decorator;

public class Rice extends Foods {

    public Rice(String name) {
        super("Rice");
    }

    @Override
    public void cook() {
        System.out.println("cook rice");
    }
}
