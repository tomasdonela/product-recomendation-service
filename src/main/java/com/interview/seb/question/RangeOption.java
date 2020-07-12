package com.interview.seb.question;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RangeOption implements AnswerOption{

    private final String name;
    private final int rangeStart;
    private final Integer rangeEnd;

    @JsonCreator
    public RangeOption(@JsonProperty("rangeStart") int rangeStart, @JsonProperty("rangeEnd") Integer rangeEnd) {
        this.name = createName(rangeStart, rangeEnd);
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    private static String createName(int rangeStart, Integer rangeEnd){
        String rangeName = String.valueOf(rangeStart);
        if(rangeEnd != null){
            rangeName = rangeName + " - " + rangeEnd;
        } else {
            rangeName = rangeName + " + ";
        }
        return rangeName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isEqual(String argument) {
        return false;
    }

    @Override
    public boolean isMoreThen(String argument) {
        return this.rangeStart > Integer.parseInt(argument);
    }

    @Override
    public boolean isMoreEqualThen(String argument) {
        return  this.rangeStart >= Integer.parseInt(argument);
    }

    @Override
    public boolean isLessThen(String argument) {
        return this.rangeEnd == null || this.rangeEnd < Integer.parseInt(argument);
    }
}
