package com.rory.designpattern.adaptor;

public class PowerSocket110VAdaptor implements PowerSocket110V {

    private PowerSocket220V powerSocket220V;

    public PowerSocket110VAdaptor(PowerSocket220V powerSocket220V) {
        this.powerSocket220V = powerSocket220V;
    }

    @Override
    public void rechargeBy110V() {
        powerSocket220V.rechargeBy220V();
    }
}
