package com.rory.designpattern.observer.event;

import java.util.EventListener;

public interface IEventListener <E extends Event> extends EventListener {
    void onEvent(E event);
}
