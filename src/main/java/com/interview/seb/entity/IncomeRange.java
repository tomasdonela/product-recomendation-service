package com.interview.seb.entity;

public enum IncomeRange implements RangeItem{
    INCOME_0("0", 0, 0),
    INCOME_1_12000("1-12000", 1, 12000),
    INCOME_12001_40000("12001-40000", 12001, 40000),
    INCOME_40001_PLUS("40001 plus", 40001, null);

    private final String name;
    private final int rangeStart;
    private final Integer rangeEnd;

    IncomeRange(String name, int rangeStart, Integer rangeEnd) {
        this.name = name;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public String getName() {
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
