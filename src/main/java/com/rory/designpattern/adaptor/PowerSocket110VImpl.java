package com.rory.designpattern.adaptor;

public class PowerSocket110VImpl implements PowerSocket110V {
    @Override
    public void rechargeBy110V() {
        System.out.println("110v is recharging");
    }
}
