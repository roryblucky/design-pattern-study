package com.rory.designpattern.memento;

public class Emp {
    private String name;
    private String age;
    private String money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public EmpSnapshot createSnapShot() {
        return new EmpSnapshot(this);
    }

    public void recovery(EmpSnapshot snapshot) {
        this.name = snapshot.getName();
        this.money = snapshot.getMoney();
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
