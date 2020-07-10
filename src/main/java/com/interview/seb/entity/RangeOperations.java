package com.interview.seb.entity;

public class RangeOperations {

    private RangeItem item;

    private RangeOperations(RangeItem item){
        this.item = item;
    }

    public String getName(){
        return item.getName();
    }

    public boolean isMoreThen(int amount){
        return item.getRangeStart() > amount;
    }

    public boolean isMoreEqualThen(int amount){
        return item.getRangeStart() >= amount;
    }

    public boolean isLessThen(int amount){
        return item.getRangeEnd() == null || item.getRangeEnd() < amount;
    }

    static RangeOperations valueOf(RangeItem item){
        return new RangeOperations(item);
    }
}
