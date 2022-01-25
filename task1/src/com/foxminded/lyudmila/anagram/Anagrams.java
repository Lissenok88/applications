package com.foxminded.lyudmila.anagram;

public class Anagrams {
    public String reversesLettersInWords(String string) {
        String[] words = string.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reversesAllLetters(words[i]);
        }
        return String.join(" ", words);

    }

    private String reversesAllLetters(String word) {
        StringBuilder result = new StringBuilder(word);
        int start = 0;
        int end = result.length() - 1;
        while (start < end) {
            if (!Character.isLetter(result.charAt(start))) {
                start++;
            } else if (!Character.isLetter(result.charAt(end))) {
                end--;
            } else {
                final char letter = result.charAt(start);
                result.setCharAt(start, result.charAt(end));
                result.setCharAt(end, letter);
                start++;
                end--;
            }
        }
        return result.toString();
    }
}