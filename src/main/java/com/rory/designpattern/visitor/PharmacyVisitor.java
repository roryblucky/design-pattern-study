package com.rory.designpattern.visitor;

/**
 * 药房
 */
public class PharmacyVisitor extends Visitor {

    public PharmacyVisitor(String name) {
        super(name);
    }

    @Override
    public void visitMedicineA(MedicineA medicineA) {
        System.out.println("药房拿" + medicineA.getName());
    }

    @Override
    public void visitMedicineB(MedicineB medicineB) {
        System.out.println("药房拿" + medicineB.getName());
    }
}
