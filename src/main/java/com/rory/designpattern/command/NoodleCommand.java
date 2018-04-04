package com.rory.designpattern.command;

public class NoodleCommand extends AbstractCommand {

    public NoodleCommand(Cooker cooker) {
        super(cooker);
    }

    @Override
    public void execute() {
        cooker.doNoodle();
    }
}
