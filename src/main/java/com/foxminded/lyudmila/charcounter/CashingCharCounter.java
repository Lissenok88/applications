package com.foxminded.lyudmila.charcounter;

import java.util.*;

public class CashingCharCounter {
    private final Map<String, String> cache = new HashMap<>();

    public String getUniqueChars(String string) {
        cache.computeIfAbsent(string, key -> new CharCounter().calculateUniqueChars(string));
        return cache.get(string);
    }
}
