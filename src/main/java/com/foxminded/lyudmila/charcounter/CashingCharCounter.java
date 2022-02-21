package com.foxminded.lyudmila.charcounter;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CashingCharCounter {
    private static final Integer cacheMaxSize = 1000;

    private final Cache<String, String> cache;

    public CashingCharCounter() {
        this.cache = Caffeine.newBuilder()
            .maximumSize(cacheMaxSize)
            .build();
    }

    public CashingCharCounter(Integer cacheSize) {
        this.cache = Caffeine.newBuilder()
            .maximumSize(cacheSize)
            .build();
    }

    public String getUniqueChars(String string) {
        return getCache().get(string, key -> new CharCounter().calculateUniqueChars(string));
    }

    public Cache<String, String> getCache() {
        return cache;
    }
}
