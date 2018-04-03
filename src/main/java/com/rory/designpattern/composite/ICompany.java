package com.rory.designpattern.composite;

public abstract class ICompany {


    public abstract void add(ICompany department);
    public abstract void remove(ICompany department);
    public abstract void disPlay(int depth);
}
