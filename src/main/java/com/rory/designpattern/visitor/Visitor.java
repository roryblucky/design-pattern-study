package com.rory.designpattern.visitor;

public abstract class Visitor {
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buyMedicines(Prescription prescription) {
        prescription.getMedicines().forEach(medicine -> {
            medicine.accept(this);
        });
    }

    public abstract void visitMedicineA(MedicineA medicineA);

    public abstract void visitMedicineB(MedicineB medicineB);
}
