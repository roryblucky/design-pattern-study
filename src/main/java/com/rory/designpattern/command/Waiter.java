package com.rory.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<AbstractCommand> commands = new ArrayList<>();


    public void addCommand(AbstractCommand abstractCommand) {
        commands.add(abstractCommand);
    }

    public void undo(AbstractCommand command) {
        commands.remove(command);
    }

    public void placeOrder() {
        commands.forEach(AbstractCommand::execute);
    }
}
