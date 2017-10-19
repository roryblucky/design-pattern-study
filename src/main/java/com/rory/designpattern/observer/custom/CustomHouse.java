package com.rory.designpattern.observer.custom;

public class CustomHouse extends CustomObservable {
    private double price;

    public CustomHouse() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.notifyObserver();
    }
}
