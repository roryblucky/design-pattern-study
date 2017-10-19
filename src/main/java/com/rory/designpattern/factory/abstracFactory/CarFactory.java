package com.rory.designpattern.factory.abstracFactory;

import com.rory.designpattern.factory.Car;

public interface CarFactory {
    Car produceBMW(String carNum);

    Car produceAudi(String carNum);
}
