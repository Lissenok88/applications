package com.foxminded.lyudmila.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCounter {
    public String calculateUniqueChars(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("String is empty or null");
        }
        Map<Character, Integer> result = new LinkedHashMap<>();
        input.chars().forEach(charAsInt -> result.merge((char) charAsInt, 1, Integer::sum));

        return convertResultInString(result);
    }

    private String convertResultInString(Map<Character, Integer> result) {
        return result.keySet().stream().map(key -> "\"" + key + "\" - " + result.get(key))
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
