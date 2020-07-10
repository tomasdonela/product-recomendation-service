package com.interview.seb.entity;

public interface RangeItem {
    String getName();
    int getRangeStart();
    Integer getRangeEnd();
    default RangeOperations getOperations(){
        return RangeOperations.valueOf(this);
    }
}
