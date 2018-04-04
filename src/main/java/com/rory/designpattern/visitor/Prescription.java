package com.rory.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 处方
 */
public class Prescription {
    private List<Medicine> medicines = new ArrayList<>();

    public void addMedicine(Medicine medicine) {
        this.medicines.add(medicine);
    }

    public void removeMedicine(Medicine medicine) {
        this.medicines.remove(medicine);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

}
