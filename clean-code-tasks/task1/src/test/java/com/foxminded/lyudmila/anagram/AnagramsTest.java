package com.foxminded.lyudmila.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {
    Anagrams anagram;

    @BeforeEach()
    void createNewAnagrams() {
        anagram = new Anagrams();
    }

    @Test
    void reversesLettersInWords_shouldReturnEmptyString_whenEmptyString() {
        assertEquals("", anagram.reversesLettersInWords(""));
    }

    @Test
    void reversesLettersInWords_shouldReturnThrowException_whenNull() {
        assertThrows(NullPointerException.class, () -> {
            anagram.reversesLettersInWords(null);
        });
    }

    @Test
    void reversesLettersInWords_shouldReturnSingleSpace_whenSingleSpace() {
        assertEquals(" ", anagram.reversesLettersInWords(" "));
    }

    @Test
    void reversesLettersInWords_shouldReturnSeveralSpaces_whenSeveralSpaces() {
        assertEquals("   ", anagram.reversesLettersInWords("   "));
    }

    @Test
    void reversesLettersInWords_shouldReturnSingleSymbol_whenSingleSymbol() {
        assertEquals("1", anagram.reversesLettersInWords("1"));
    }

    @Test
    void reversesLettersInWords_shouldReturnTwoSpacesAndSymbol_whenTwoSpacesAndSymbol() {
        assertEquals("  2", anagram.reversesLettersInWords("  2"));
    }

    @Test
    void reversesLettersInWords_shouldReturnTwoWordsWithTwoSpaces_whenTwoWordsWithTwoSpaces() {
        assertEquals("  fj2k  kj2f", anagram.reversesLettersInWords("  kj2f  fj2k"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSeveralIdenticalLetters_whenSeveralIdenticalLetters() {
        assertEquals("aaa", anagram.reversesLettersInWords("aaa"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSeveralIdenticalLettersAndSymbol_whenSeveralIdenticalLettersAndSymbol() {
        assertEquals("aa2a", anagram.reversesLettersInWords("aa2a"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSameUpperAndLowerLettersMixed_whenSameUpperAndLowerLettersMixed() {
        assertEquals("abcAb", anagram.reversesLettersInWords("bAcba"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSameUpLowLettersMixedAndSymbol_whenSameUpLowLettersMixedAndSymbol() {
        assertEquals("aacA2b", anagram.reversesLettersInWords("bAca2a"));
    }

    @Test
    void reversesLettersInWords_shouldReturnDifferentLetters_whenDifferentLetters() {
        assertEquals("abcd", anagram.reversesLettersInWords("dcba"));
    }

    @Test
    void reversesLettersInWords_shouldReturnOnlySymbols_whenOnlySymbols() {
        assertEquals("+<>", anagram.reversesLettersInWords("+<>"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSeveralWords_whenSeveralWords() {
        assertEquals("abd sd1f 2fd2g", anagram.reversesLettersInWords("dba fd1s 2gd2f"));
    }
}