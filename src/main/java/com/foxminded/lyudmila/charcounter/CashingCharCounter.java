package com.foxminded.lyudmila.charcounter;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CashingCharCounter extends BaseCharCounterDecorator {
    private static final Integer cacheMaxSize = 1000;

    private final Cache<String, String> cache;

    public CashingCharCounter(CharCounter charCounter) {
        super(charCounter);
        this.cache = Caffeine.newBuilder()
            .maximumSize(cacheMaxSize)
            .build();

    }

    public CashingCharCounter(CharCounter charCounter, Integer cacheSize) {
        super(charCounter);
        this.cache = Caffeine.newBuilder()
            .maximumSize(cacheSize)
            .build();
    }

    public String getUniqueChars(String input) {
        return cache.get(input, key -> calculateUniqueChars(input));
    }
}
