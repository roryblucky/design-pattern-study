package com.rory.designpattern.builder;

import java.util.LinkedList;
import java.util.List;

public class Computer {
    private List<String> components = new LinkedList<>();

    public void addComponent(String component) {
        components.add(component);
    }

    public void showConfig() {
        System.out.println(components);
    }
}
