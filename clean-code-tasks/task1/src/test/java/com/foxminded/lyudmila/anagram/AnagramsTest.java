package com.foxminded.lyudmila.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {
    private final Anagrams anagram = new Anagrams();

    @Test
    void givenEmptyString_onReversesLettersInWords_shouldEmptyString() {
        assertEquals("", anagram.reversesLettersInWords(""));
    }

    @Test
    void givenNull_onReversesLettersInWords_shouldThrowException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            anagram.reversesLettersInWords(null);
        });
        assertNotNull("Null parameters are not allowed", exception.getMessage());
    }

    @Test
    void givenSingleSpace_onReversesLettersInWords_shouldSingleSpace() {
        assertEquals(" ", anagram.reversesLettersInWords(" "));
    }

    @Test
    void givenSeveralSpaces_onReversesLettersInWords_shouldSeveralSpaces() {
        assertEquals("   ", anagram.reversesLettersInWords("   "));
    }

    @Test
    void givenSingleSymbol_onReversesLettersInWords_shouldSingleSymbol() {
        assertEquals("1", anagram.reversesLettersInWords("1"));
    }

    @Test
    void givenTwoSpacesAndSymbol_onReversesLettersInWords_shouldTwoSpacesAndSymbol() {
        assertEquals("  2", anagram.reversesLettersInWords("  2"));
    }

    @Test
    void givenTwoWordsWithTwoSpaces_onReversesLettersInWords_shouldTwoWordsWithTwoSpaces() {
        assertEquals("  fj2k  kj2f", anagram.reversesLettersInWords("  kj2f  fj2k"));
    }

    @Test
    void givenSeveralIdenticalLetters_onReversesLettersInWords_shouldSeveralIdenticalLetters() {
        assertEquals("aaa", anagram.reversesLettersInWords("aaa"));
    }

    @Test
    void givenSeveralIdenticalLettersAndSymbol_onReversesLettersInWords_shouldSeveralIdenticalLettersAndSymbol() {
        assertEquals("aa2a", anagram.reversesLettersInWords("aa2a"));
    }

    @Test
    void givenSameUpperAndLowerLettersMixed_onReversesLettersInWords_shouldSameUpperAndLowerLettersMixed() {
        assertEquals("abcAb", anagram.reversesLettersInWords("bAcba"));
    }

    @Test
    void givenSameUpLowLettersMixedAndSymbol_onReversesLettersInWords_shouldSameUpLowLettersMixedAndSymbol() {
        assertEquals("aacA2b", anagram.reversesLettersInWords("bAca2a"));
    }

    @Test
    void givenDifferentLetters_onReversesLettersInWords_shouldDifferentLetters() {
        assertEquals("abcd", anagram.reversesLettersInWords("dcba"));
    }

    @Test
    void givenOnlySymbols_onReversesLettersInWords_shouldOnlySymbols() {
        assertEquals("+<>", anagram.reversesLettersInWords("+<>"));
    }

    @Test
    void givenFewWords_onReversesLettersInWords_shouldFewWords() {
        assertEquals("abd sd1f 2fd2g", anagram.reversesLettersInWords("dba fd1s 2gd2f"));
    }
}