package com.rory.designpattern.observer.event;

public class DelEventListener implements IEventListener<DelEvent> {
    @Override
    public void onEvent(DelEvent event) {
        System.out.println("del event");
    }
}
