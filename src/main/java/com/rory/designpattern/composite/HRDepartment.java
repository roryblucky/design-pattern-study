package com.rory.designpattern.composite;

public class HRDepartment extends ICompany {
    @Override
    public void add(ICompany department) {
        System.out.println("不能增加节点");
    }

    @Override
    public void remove(ICompany department) {
        System.out.println("不能增加节点");
    }


}
