package com.rory.designpattern.factory.normalFactory;

import com.rory.designpattern.factory.Car;
import com.rory.designpattern.factory.simpleFactory.AudiCar;

public class AudiFactory implements CarFactory {
    @Override
    public Car produceCar(String carNum) {
        return new AudiCar(carNum);
    }
}
