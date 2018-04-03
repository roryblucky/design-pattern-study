package com.rory.designpattern.memento;

public class EmpSnapshot {
    private String money;
    private String name;

    public EmpSnapshot(Emp emp) {
        this.money = emp.getMoney();
        this.name = emp.getName();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
