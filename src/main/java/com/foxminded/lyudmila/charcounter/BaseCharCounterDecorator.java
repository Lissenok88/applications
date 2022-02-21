package com.foxminded.lyudmila.charcounter;

public class BaseCharCounterDecorator {
    private final CharCounter charCounter;

    public BaseCharCounterDecorator(CharCounter charCounter) {
        this.charCounter = charCounter;
    }

    public String calculateUniqueChars(String input) {
        return charCounter.calculateUniqueChars(input);
    }
}
