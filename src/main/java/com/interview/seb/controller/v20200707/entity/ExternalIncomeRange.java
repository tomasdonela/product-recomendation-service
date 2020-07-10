package com.interview.seb.controller.v20200707.entity;

import com.interview.seb.entity.IncomeRange;
import java.util.Optional;

public enum ExternalIncomeRange {
    INCOME_0, INCOME_1_12000, INCOME_12001_40000, INCOME_40001_PLUS;

    public IncomeRange toInternal(){
        return Optional.of(IncomeRange.valueOf(this.name()))
                .orElseThrow(()-> new IllegalArgumentException("invalid IncomeRange"));
    }
}
