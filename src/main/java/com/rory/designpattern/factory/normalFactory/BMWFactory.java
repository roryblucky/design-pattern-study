package com.rory.designpattern.factory.normalFactory;

import com.rory.designpattern.factory.Car;
import com.rory.designpattern.factory.simpleFactory.BMWCar;

public class BMWFactory implements CarFactory {
    @Override
    public Car produceCar(String carNum) {
        return new BMWCar(carNum);
    }
}
