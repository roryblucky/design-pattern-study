package com.rory.designpattern.composite;

public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company department);
    public abstract void remove(Company department);
    public abstract void disPlay(int depth);

    protected String getPrefix(int depth) {
        StringBuilder builder = new StringBuilder("-");
        for(int i = 0; i <= depth; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
