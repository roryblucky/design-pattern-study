package com.rory.designpattern.decorator;

public class SaltDecorator extends FlavorDecorator {

    public SaltDecorator(String name, Foods foods) {
        super(name, foods);
    }

    @Override
    public void cook() {
        foods.cook();
        System.out.println("add salt");
    }
}
