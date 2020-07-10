package com.interview.seb.entity;

public enum AgeRange implements RangeItem {
    AGE_0_17("0-17", 0, 17),
    AGE_18_64("18-64",18, 64),
    AGE_65_PLUS("64 plus",64, null);

    private final String name;
    private final int rangeStart;
    private final Integer rangeEnd;

    AgeRange(String name, int rangeStart, Integer rangeEnd) {
        this.name = name;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getRangeStart() {
        return rangeStart;
    }

    @Override
    public Integer getRangeEnd() {
        return rangeEnd;
    }
}
