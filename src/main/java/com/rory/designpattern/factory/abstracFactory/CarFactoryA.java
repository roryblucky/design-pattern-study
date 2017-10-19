package com.rory.designpattern.factory.abstracFactory;

import com.rory.designpattern.factory.Car;
import com.rory.designpattern.factory.simpleFactory.AudiCar;
import com.rory.designpattern.factory.simpleFactory.BMWCar;

public class CarFactoryA implements CarFactory {

    @Override
    public Car produceBMW(String carNum) {
        return new BMWCar(carNum + "!!!");
    }

    @Override
    public Car produceAudi(String carNum) {
        return new AudiCar(carNum + "!!!");
    }
}
