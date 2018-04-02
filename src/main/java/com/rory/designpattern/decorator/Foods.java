package com.rory.designpattern.decorator;

public abstract class Foods {

    private String name;

    public Foods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void cook();
}
