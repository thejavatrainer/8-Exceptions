package com.frequentis.java.training.module7;

public class Deliverable {
    private final int internalNumber;

    public Deliverable(int internalNumber) {
        this.internalNumber = internalNumber;
    }

    public void performAction() {
        System.out.println("sent "+internalNumber);;
    }
}
