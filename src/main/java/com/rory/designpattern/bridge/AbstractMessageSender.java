package com.rory.designpattern.bridge;

public abstract class AbstractMessageSender {

    private AbstractMessage abstractMessage;//桥接sender，sender多种类型，message 也多种类型。所以分开，用桥接模式将2者结合
    private String type;

    public AbstractMessageSender(AbstractMessage abstractMessage, String type) {
        this.abstractMessage = abstractMessage;
        this.type = type;
    }

    public void send() {
        System.out.printf("%s send message %s to %s\n",type, abstractMessage.getMsg(), abstractMessage.getTarget());
    }
}
