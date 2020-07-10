package com.frewen.designpattern.command;

/**
 * 具体的命令对象
 */
public class ConcreteCommand implements ICommand {

    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
