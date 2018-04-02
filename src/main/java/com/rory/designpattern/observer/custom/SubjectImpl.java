package com.rory.designpattern.observer.custom;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements ISubject {
    private List<IObserver> observerList = new ArrayList<>();

    @Override
    public void addObserver(IObserver o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observerList.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        observerList.forEach(o -> {
            o.update();
        });
    }
}
