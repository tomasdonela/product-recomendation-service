package com.interview.seb.question;

public interface AnswerOption {
    String getName();
    boolean isEqual(String argument);
    boolean isMoreThen(String argument);
    boolean isMoreEqualThen(String argument);
    boolean isLessThen(String argument);
}
