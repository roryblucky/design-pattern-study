package com.rory.designpattern.observer.custom;

public interface ISubject {
    void addObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyAllObservers();
}
