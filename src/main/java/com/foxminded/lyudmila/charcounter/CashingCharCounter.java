package com.foxminded.lyudmila.charcounter;

import java.util.*;

public class CashingCharCounter extends Decorator {
    private static Map<String, String> cache = new HashMap<>();

    public CashingCharCounter(Calculate charsCounter) {
        super(charsCounter);
    }

    public String getUniqueChars(String string) {
        cache.computeIfAbsent(string, this::calculateUniqueChars);
        return cache.get(string);
    }
}
