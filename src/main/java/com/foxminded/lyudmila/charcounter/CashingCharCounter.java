package com.foxminded.lyudmila.charcounter;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CashingCharCounter {
    Cache<String, String> cache = Caffeine.newBuilder()
        .expireAfterAccess(5, TimeUnit.MINUTES)
        .build();

    public String getUniqueChars(String string) {
        return cache.get(string, key -> new CharCounter().calculateUniqueChars(string));
    }
}
