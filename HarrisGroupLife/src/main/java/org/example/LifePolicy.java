package org.example;// LifePolicy.java
// Purpose: Represents a life insurance policy and calculates premium costs

import java.text.DecimalFormat;

public class LifePolicy {
    private final String policyHolderName;
    private final int birthYear;
    private final int currentYear;
    private final boolean isInState;
    private final boolean isRetired;
    private double policyCost;

    // Default constructor
    public LifePolicy() {
        this.policyHolderName = "Default Name";
        this.birthYear = 1970;
        this.currentYear = 2025;
        this.isInState = true;
        this.isRetired = false;
        this.policyCost = 0.0;
    }

    // Parameterized constructor
    public LifePolicy(String policyHolderName, int birthYear, int currentYear, boolean isInState, boolean isRetired) {
        this.policyHolderName = policyHolderName;
        this.birthYear = birthYear;
        this.currentYear = currentYear;
        this.isInState = isInState;
        this.isRetired = isRetired;
        this.policyCost = 0.0;
    }

    // Calculate policy cost
    public void calculatePolicyCost() {
        int age = currentYear - birthYear;
        int decades = age / 10;

        if (isRetired) {
            policyCost = age * 7.50;
        } else if (isInState) {
            policyCost = (decades + 15) * 20.0;
        } else {
            policyCost = (decades + 15) * 22.50;
        }
    }

    // Return formatted output string
    public String getFormattedOutput() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String residencyStatus = isInState ? "In-State" : "Out-of-State";
        String retirementStatus = isRetired ? "Retiree" : "Non-Retiree";

        return String.format("Current Year: %d\nPolicy Holder: %s\nAge: %d\nResidency: %s\nRetirement Status: %s\nPolicy Cost: $%s",
                currentYear, policyHolderName, (currentYear - birthYear), residencyStatus, retirementStatus, df.format(policyCost));
    }
}
