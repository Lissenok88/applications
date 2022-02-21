package com.foxminded.lyudmila.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCounter {
    public String calculateUniqueChars(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Invalid Argument");
        }
        Map<Character, Integer> result = new LinkedHashMap<>();
        string.chars().forEach(charAsInt -> result.merge((char) charAsInt, 1, Integer::sum));

        return convertResultInString(result);
    }

    private String convertResultInString(Map<Character, Integer> result) {
        String resultAsString = result.keySet().stream()
            .map(key -> "\"" + key + "\" - " + result.get(key) + System.lineSeparator()).collect(Collectors.joining());

        return resultAsString.trim();
    }
}
