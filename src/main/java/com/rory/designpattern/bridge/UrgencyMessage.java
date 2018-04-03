package com.rory.designpattern.bridge;

public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(String msg, String target) {
        super("加急：" + msg, target);
    }
}
