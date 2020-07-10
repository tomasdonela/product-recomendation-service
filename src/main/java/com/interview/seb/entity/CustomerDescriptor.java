package com.interview.seb.entity;

public class CustomerDescriptor {

    private AgeRange ageRange;
    private boolean student;
    private IncomeRange incomeRange;

    public CustomerDescriptor(
            AgeRange ageRange, boolean student,
            IncomeRange incomeRange
    ) {
        this.ageRange = ageRange;
        this.student = student;
        this.incomeRange = incomeRange;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public boolean isStudent() {
        return student;
    }

    public IncomeRange getIncomeRange() {
        return incomeRange;
    }
}
