package com.rory.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class HNACompany extends Company {

    private List<Company> departmenets = new ArrayList<>();

    public HNACompany(String name) {
        super(name);
    }


    @Override
    public void add(Company department) {
        departmenets.add(department);
    }

    @Override
    public void remove(Company department) {
        department.remove(department);
    }

    @Override
    public void disPlay(int depth) {
        System.out.println(getPrefix(depth) + name);
        departmenets.forEach(d -> {
            d.disPlay(depth + 2);
        });
    }
}
