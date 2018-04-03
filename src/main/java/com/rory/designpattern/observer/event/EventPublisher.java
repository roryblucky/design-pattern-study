package com.rory.designpattern.observer.event;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class EventPublisher {

    private List<IEventListener> eventListeners = new ArrayList<>();

    public void addListener(IEventListener eventListener) {
        this.eventListeners.add(eventListener);
    }

    public void publishEvent(Object event) {
        Event customEvent = null;
        if (event instanceof Event) {
            customEvent = (Event) event;
        }
        invoke(customEvent);
    }

    private void invoke(Event event) {
        eventListeners.forEach(eventListener -> {
            if (event.getClass().equals(retrieveEvent(eventListener))) {
                eventListener.onEvent(event);
            }
        });
    }

    private synchronized Class retrieveEvent(IEventListener eventListener) {
        Class type = (Class) ((ParameterizedType) eventListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        return type;
    }
}
