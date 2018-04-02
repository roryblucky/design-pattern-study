package com.rory.designpattern.facade;

/**
 * Facade
 */
public class Computer implements IStartAction {

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    @Override
    public void start() {
        cpu.start();
        memory.start();
        memory.start();
        System.out.printf("Computer started");
    }
}
