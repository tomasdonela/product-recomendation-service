package com.interview.seb.controller.v20200707.entity;

import com.interview.seb.entity.CustomerDescriptor;

import static java.util.Optional.ofNullable;

public class ExternalCustomerDescriptor {

    private ExternalAgeRange ageRange;
    private Boolean student;
    private ExternalIncomeRange incomeRange;

    public ExternalCustomerDescriptor(
            ExternalAgeRange ageRange, Boolean student,
            ExternalIncomeRange incomeRange
    ) {
        this.ageRange = ageRange;
        this.student = student;
        this.incomeRange = incomeRange;
    }

    public ExternalAgeRange getAgeRange() {
        return ageRange;
    }

    public Boolean getStudent() {
        return student;
    }

    public ExternalIncomeRange getIncomeRange() {
        return incomeRange;
    }

    public CustomerDescriptor toInternal(){
        return new CustomerDescriptor(
                this.getAgeRange().toInternal(),
                ofNullable(this.getStudent()).orElse(false),
                this.getIncomeRange().toInternal());
    }
}
