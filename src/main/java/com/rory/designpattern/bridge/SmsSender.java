package com.rory.designpattern.bridge;

public class SmsSender extends AbstractMessageSender {

    public SmsSender(AbstractMessage abstractMessage) {
        super(abstractMessage, "SMS");
    }
}
