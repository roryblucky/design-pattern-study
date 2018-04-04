package com.rory.designpattern.visitor;

public class MedicineA extends Medicine {

    public MedicineA(String name, double price) {
        super(name, price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMedicineA(this);
    }
}
