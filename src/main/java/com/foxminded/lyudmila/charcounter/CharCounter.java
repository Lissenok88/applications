package com.foxminded.lyudmila.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CharCounter {
    public String calculateUniqueChars(String string) {
        Optional<String> checker = Optional.ofNullable(string);
        string = checker.orElseThrow(() -> new IllegalArgumentException("Invalid Argument"));

        Map<Character, Integer> result = new LinkedHashMap<>();
        string.chars().forEach(charAsInt -> result.merge((char) charAsInt, 1, Integer::sum));

        return convertResultInString(result);
    }

    private String convertResultInString(Map<Character, Integer> result) {
        String resultAsString = result.keySet().stream()
            .map(key -> "\"" + key + "\" - " + result.get(key) + "\n").collect(Collectors.joining());

        return resultAsString.trim();
    }
}
