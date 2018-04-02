package com.rory.designpattern.decorator;

public class BeefDecorator extends FlavorDecorator {

    public BeefDecorator(String name, Foods foods) {
        super(name, foods);
    }

    @Override
    public void cook() {
        foods.cook();
        System.out.println("add beef");
    }
}
