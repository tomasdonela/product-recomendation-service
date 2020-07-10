package com.interview.seb.controller.v20200707.entity;

import com.interview.seb.entity.AgeRange;
import java.util.Optional;

public enum ExternalAgeRange {
    AGE_0_17, AGE_18_64, AGE_65_PLUS;

    public AgeRange toInternal(){
        return Optional.of(AgeRange.valueOf(this.name()))
                .orElseThrow(()-> new IllegalArgumentException("invalid AgeRange"));
    }
}
