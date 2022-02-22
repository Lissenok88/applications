package com.foxminded.lyudmila.charcounter;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CachingCharCounter {
    private static final Integer cacheMaxSize = 1000;

    private final Cache<String, String> cache;
    private final CharCounter charCounter;

    public CachingCharCounter(CharCounter charCounter) {
        this.charCounter = charCounter;
        this.cache = Caffeine.newBuilder()
            .maximumSize(cacheMaxSize)
            .build();
    }

    public String getUniqueChars(String input) {
        return cache.get(input, key -> charCounter.calculateUniqueChars(input));
    }
}
