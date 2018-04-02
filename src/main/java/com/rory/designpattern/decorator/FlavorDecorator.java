package com.rory.designpattern.decorator;

public abstract class FlavorDecorator extends Foods {

    protected Foods foods;

    public FlavorDecorator(String name, Foods foods) {
        super(name);
        this.foods = foods;
    }
}
