package com.rory.designpattern.builder;

public class Director {

    public Computer constructComputer(IComputerBuilder computerBuilder) {
        return (Computer) computerBuilder.buildCPU().buildDisk().buildMemory().build();
    }
}
