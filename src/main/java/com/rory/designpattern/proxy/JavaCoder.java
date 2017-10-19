package com.rory.designpattern.proxy;

public class JavaCoder implements ICoder {

    @Override
    public void writeCode(String code) {
        System.out.println("Senior Java is writing code: " + code);
    }
}
