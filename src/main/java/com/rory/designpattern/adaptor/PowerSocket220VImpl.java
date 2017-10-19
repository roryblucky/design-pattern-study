package com.rory.designpattern.adaptor;

public class PowerSocket220VImpl implements PowerSocket220V {
    @Override
    public void rechargeBy220V() {
        System.out.println("220v is recharging");
    }
}
