package com.rory.designpattern.composite;

public class ITDepartment extends Company {

    public ITDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company department) {

    }

    @Override
    public void remove(Company department) {

    }

    @Override
    public void disPlay(int depth) {
        System.out.println(getPrefix(depth) + name);
    }
}
