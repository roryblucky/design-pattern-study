package com.rory.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class HNACompany extends ICompany {

    private String name;

    private List<ICompany> departmenets = new ArrayList<>();

    public HNACompany(String name) {
        this.name = name;
    }


    @Override
    public void add(ICompany department) {
        departmenets.add(department);
    }

    @Override
    public void remove(ICompany department) {
        department.remove(department);
    }

    @Override
    public void disPlay(int depth) {
        StringBuilder builder = new StringBuilder("-");
        for(int i = 0; i <= depth; i++) {
            builder.append("-");
        }
        System.out.println(builder.append(name).toString());
        departmenets.forEach(d -> {
            d.disPlay(depth + 2);
        });
    }
}
