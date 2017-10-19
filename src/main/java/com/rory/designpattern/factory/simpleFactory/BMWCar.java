package com.rory.designpattern.factory.simpleFactory;

import com.rory.designpattern.factory.AbstractCar;

public class BMWCar extends AbstractCar {
    public BMWCar(String carNum) {
        super(carNum);
    }

    @Override
    public void drive() {
        System.out.println(this.getCarNum() + "BMW -----------go!");
    }
}
