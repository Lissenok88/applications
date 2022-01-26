package com.foxminded.lyudmila.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {
    private Anagrams anagram;

    @BeforeEach()
    void createNewAnagrams() {
        anagram = new Anagrams();
    }

    @Test
    void reversesLettersInWords_shouldReturnEmptyString_whenEmptyString() {
        assertEquals("", anagram.reversesLettersInWords(""));
    }

    @Test
    void reversesLettersInWords_shouldReturnNull_whenNull() {
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
    void reversesLettersInWords_shouldReturnSomeIdenticalLetters_whenSomeIdenticalLetters() {
        assertEquals("aaa", anagram.reversesLettersInWords("aaa"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSomeIdenticalLettersInUpAndLow_whenSomeIdenticalLettersInUpAndLow() {
        assertEquals("aaaAa", anagram.reversesLettersInWords("aAaaa"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSomeIdenticalLettersAndSymbol_whenSomeIdenticalLettersAndSymbol() {
        assertEquals("aa2a", anagram.reversesLettersInWords("aa2a"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSameUpperAndLowerLettersMixed_whenUpperAndLowerLettersMixed() {
        assertEquals("abcAb", anagram.reversesLettersInWords("bAcba"));
    }

    @Test
    void reversesLettersInWords_shouldReturnUpLowLettersMixedAndSymbol_whenUpLowLettersMixedAndSymbol() {
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

    @Test
    void reversesLettersInWords_shouldReturnSomeSpacesBeforeAndAfterWords_whenSomeSpacesBeforeAndAfterWords() {
        assertEquals("   emos gnirts   ", anagram.reversesLettersInWords("   some string   "));
    }

    @Test
    void reversesLettersInWords_shouldReturnWordWithNotLatinLetters_whenWordWithNotLatinLetters() {
        assertEquals("акортс", anagram.reversesLettersInWords("строка"));
    }

    @Test
    void reversesLettersInWords_shouldReturnWordsWithNotLatinLetters_whenWordsWithNotLatinLetters() {
        assertEquals("акортс авкуб", anagram.reversesLettersInWords("строка буква"));
    }

    @Test
    void reversesLettersInWords_shouldReturnWordWithNotLatinLettersAndSymbol_whenWordWithNotLatinLettersAndSymbol() {
        assertEquals("акор2тс", anagram.reversesLettersInWords("стро2ка"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSomeIdenticalNotLatinLetters_whenWordWithSomeIdenticalNotLatinLetters() {
        assertEquals("ддд", anagram.reversesLettersInWords("ддд"));
    }

    @Test
    void reversesLettersInWords_shouldReturnSomeIdenticalInUpAndLowNotLatin_whenSomeIdenticalInUpAndLowNotLatin() {
        assertEquals("дДддд", anagram.reversesLettersInWords("дддДд"));
    }

    @Test
    void reversesLettersInWords_shouldReturnLatinAndNotLatinLettersAndSymbols_whenLatinAndNotLatinLettersAndSymbols() {
        assertEquals("fff5,ддд", anagram.reversesLettersInWords("ддд5,fff"));
    }

    @Test
    void reversesLettersInWords_shouldReturnNotLatinLettersAndSomeSpaces_whenNotLatinLettersAndSomeSpaces() {
        assertEquals("   акортс ловмис  ", anagram.reversesLettersInWords("   строка символ  "));
    }
}