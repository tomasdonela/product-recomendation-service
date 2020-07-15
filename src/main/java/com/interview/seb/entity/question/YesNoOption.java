package com.interview.seb.entity.question;

public enum YesNoOption implements AnswerOption{
    YES("Yes"), NO("No");

    private final String name;

    YesNoOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isEqual(String argument) {
        return this.equals(YesNoOption.valueOf(argument));
    }

    @Override
    public boolean isMoreThen(String argument) {
        return false;
    }

    @Override
    public boolean isMoreEqualThen(String argument) {
        return false;
    }

    @Override
    public boolean isLessThen(String argument) {
        return false;
    }
}
