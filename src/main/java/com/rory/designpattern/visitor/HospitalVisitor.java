package com.rory.designpattern.visitor;

/**
 * 药房
 */
public class HospitalVisitor extends Visitor {

    public HospitalVisitor(String name) {
        super(name);
    }

    @Override
    public void visitMedicineA(MedicineA medicineA) {
        System.out.println("医院拿" + medicineA.getName());
    }

    @Override
    public void visitMedicineB(MedicineB medicineB) {
        System.out.println("医院" + medicineB.getName());
    }
}
