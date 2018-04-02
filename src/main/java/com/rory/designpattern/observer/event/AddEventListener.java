package com.rory.designpattern.observer.event;

public class AddEventListener implements IEventListener<AddEvent> {

    @Override
    public void onEvent(AddEvent event) {
        System.out.println("add event");
    }
}
