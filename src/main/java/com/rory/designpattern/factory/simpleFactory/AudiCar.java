package com.rory.designpattern.factory.simpleFactory;

import com.rory.designpattern.factory.AbstractCar;

public class AudiCar extends AbstractCar {

    public AudiCar(String carNum) {
        super(carNum);
    }

    @Override
    public void drive() {
        System.out.println(this.getCarNum() + "Audi -----------go!");
    }
}
