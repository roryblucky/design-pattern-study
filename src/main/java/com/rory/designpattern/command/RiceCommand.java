package com.rory.designpattern.command;

public class RiceCommand extends AbstractCommand {

    public RiceCommand(Cooker cooker) {
        super(cooker);
    }

    @Override
    public void execute() {
        cooker.doRice();
    }
}
