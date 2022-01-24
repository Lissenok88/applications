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
        StringBuilder reversesWord = new StringBuilder(word);
        int start = 0;
        int end = reversesWord.length() - 1;
        while (start < end) {
            if (!Character.isLetter(reversesWord.charAt(start))) {
                start++;
            } else if (!Character.isLetter(reversesWord.charAt(end))) {
                end--;
            } else {
                final char letter = reversesWord.charAt(start);
                reversesWord.setCharAt(start, reversesWord.charAt(end));
                reversesWord.setCharAt(end, letter);
                start++;
                end--;
            }
        }
        return reversesWord.toString();
    }
}
