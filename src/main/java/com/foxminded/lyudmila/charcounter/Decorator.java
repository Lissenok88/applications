package com.foxminded.lyudmila.charcounter;

public class Decorator implements Calculate {
    private Calculate calculate;

    public Decorator(Calculate calculate) {
        this.calculate = calculate;
    }

    @Override
    public String calculateUniqueChars(String string) {
        return calculate.calculateUniqueChars(string);
    }
}
