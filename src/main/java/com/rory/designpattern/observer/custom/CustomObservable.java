package com.rory.designpattern.observer.custom;

import java.util.LinkedList;
import java.util.List;

public class CustomObservable {
    private List<CustomObserver> observerList = new LinkedList<>();


    public void addObserver(CustomObserver customObserver) {
        observerList.add(customObserver);
    }

    public void notifyObserver() {
        observerList.forEach(customObserver -> customObserver.change(this));
    }
}
