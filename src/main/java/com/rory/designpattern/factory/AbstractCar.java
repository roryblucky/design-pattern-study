package com.rory.designpattern.factory;

public abstract class AbstractCar implements Car {
    private String carNum;


    public AbstractCar(String carNum) {
        this.carNum = carNum;
    }

    public String getCarNum() {
        return carNum;
    }
}
