package com.rory.designpattern.bridge;

public class EmailSender extends AbstractMessageSender {
    public EmailSender(AbstractMessage abstractMessage) {
        super(abstractMessage, "Email");
    }
}
