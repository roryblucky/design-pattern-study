package com.rory.designpattern.factory.normalFactory;

import com.rory.designpattern.factory.Car;

public interface CarFactory {
    Car produceCar(String carNum);
}
