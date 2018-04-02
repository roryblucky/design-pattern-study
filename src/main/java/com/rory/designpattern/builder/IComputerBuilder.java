package com.rory.designpattern.builder;

public interface IComputerBuilder<T> {
    IComputerBuilder buildCPU();
    IComputerBuilder buildMemory();
    IComputerBuilder buildDisk();
    T build();
}
