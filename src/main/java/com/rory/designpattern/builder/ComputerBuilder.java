package com.rory.designpattern.builder;

public class ComputerBuilder implements IComputerBuilder<Computer> {

    private Computer computer = new Computer();

    @Override
    public IComputerBuilder buildCPU() {
        System.out.println("build CPU");
        computer.addComponent("cpu");
        return this;
    }

    @Override
    public IComputerBuilder buildMemory() {
        System.out.println("build Memory");
        computer.addComponent("memory");
        return this;
    }

    @Override
    public IComputerBuilder buildDisk() {
        System.out.println("build Disk");
        computer.addComponent("disk");
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }


}
