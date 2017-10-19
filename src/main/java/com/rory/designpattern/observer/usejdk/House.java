package com.rory.designpattern.observer.usejdk;

import java.util.Observable;

public class House extends Observable {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.setChanged();
        this.notifyObservers();
    }
}
