package com.rory.designpattern.command;

public abstract class AbstractCommand {

    protected Cooker cooker;

    public AbstractCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    public abstract void execute();
}
