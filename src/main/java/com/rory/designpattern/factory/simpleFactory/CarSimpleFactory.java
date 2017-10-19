package com.rory.designpattern.factory.simpleFactory;

import com.rory.designpattern.factory.Car;

public class CarSimpleFactory {

    public Car getCar(String name) {
        switch (name) {
            case "audi":
                return new AudiCar("11111");
            case "bmw":
                return new BMWCar("333333");
            default:
                return new AudiCar("2222222");
        }
    }
}
