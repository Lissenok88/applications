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
    void reversesLettersInWords_shouldReturnAsManySpaces_whenOnlySpaces() {
        assertEquals("   ", anagram.reversesLettersInWords("   "));
    }

    @Test
    void reversesLettersInWords_shouldReturnSingleSymbol_whenSingleSymbol() {
        assertEquals("1", anagram.reversesLettersInWords("1"));
    }

    @Test
    void reversesLettersInWords_shouldReturnTwoSpacesAndSymbolOnSamePlace_whenTwoSpacesAndSymbol() {
        assertEquals("  2", anagram.reversesLettersInWords("  2"));
    }

    @Test
    void reversesLettersInWords_shouldReturnTwoSpacesBeforeEachWordAndReverseLatinLettersAndSymbolOnSamePlaceInWords_whenTwoSpacesBeforeEachWordAndWordsWithLatinLettersAndSymbol() {
        assertEquals("  fj2k  kj2f", anagram.reversesLettersInWords("  kj2f  fj2k"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversSeveralIdenticalLatinLettersInWord_whenWordWithSeveralIdenticalLatinLetters() {
        assertEquals("aaa", anagram.reversesLettersInWords("aaa"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseSeveralIdenticalLatinLettersInLowerAndUpperCaseInWord_whenWordWithSeveralIdenticalLatinLettersInLowerAndUpperCase() {
        assertEquals("aaaAa", anagram.reversesLettersInWords("aAaaa"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversSeveralIdenticalLatinLettersAndSymbolOnSamePlace_whenWordWithSeveralIdenticalLatinLettersAndSymbol() {
        assertEquals("aa2a", anagram.reversesLettersInWords("aa2a"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseLatinLettersInUpperAndLowerCaseInWord_whenWordWithLatinLettersInUpperAndLowerCase() {
        assertEquals("abcAb", anagram.reversesLettersInWords("bAcba"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseLatinLettersInUpperAndLowerCaseSymbolOnSamePlaceInWord_whenWordWithLatinLettersInUpperAndLowerCaseAndSymbol() {
        assertEquals("aacA2b", anagram.reversesLettersInWords("bAca2a"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseDifferentLatinLettersInLowerCaseInWord_whenWordWithDifferentLatinLettersInLowerCase() {
        assertEquals("abcd", anagram.reversesLettersInWords("dcba"));
    }

    @Test
    void reversesLettersInWords_shouldReturnOnlySymbolsOnSamePlaceInWord_whenWordOnlySymbols() {
        assertEquals("+<>", anagram.reversesLettersInWords("+<>"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversLatinLettersInWordsSymbolsOnSamePlace_whenSeveralWordsWithLatinLettersAndSymbols() {
        assertEquals("abd sd1f 2fd2g", anagram.reversesLettersInWords("dba fd1s 2gd2f"));
    }

    @Test
    void reversesLettersInWords_shouldReturnAsManySpacesBeginAndEndStringReversLatinLettersInWords_whenSeveralSpacesBeginAndEndStringWordsWithLatinLetters() {
        assertEquals("   emos gnirts   ", anagram.reversesLettersInWords("   some string   "));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversNotLatinLettersInWord_whenWordWithNotLatinLetters() {
        assertEquals("акортс", anagram.reversesLettersInWords("строка"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseNotLatinLettersInWords_whenWordsWithNotLatinLetters() {
        assertEquals("акортс авкуб", anagram.reversesLettersInWords("строка буква"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversNotLatinLettersAndSymbolOnSamePlaceInWord_whenWordWithNotLatinLettersAndSymbol() {
        assertEquals("акор2тс", anagram.reversesLettersInWords("стро2ка"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversSeveralIdenticalNotLatinLettersInWord_whenWordWithSeveralIdenticalNotLatinLetters() {
        assertEquals("ддд", anagram.reversesLettersInWords("ддд"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseSeveralIdenticalNotLatinLettersInLowerAndUpperCaseInWord_whenWordWithSeveralIdenticalNotLatinLettersInLowerAndUpperCase() {
        assertEquals("дДддд", anagram.reversesLettersInWords("дддДд"));
    }

    @Test
    void reversesLettersInWords_shouldReturnReversLatinAndNotLatinLettersAndAllSymbolsOnSamePlaceInWord_whenWordWithLatinAndNotLatinLettersAndDifferentSymbols() {
        assertEquals("fff5,ддд", anagram.reversesLettersInWords("ддд5,fff"));
    }

    @Test
    void reversesLettersInWords_shouldReturnAsManySpacesBeginAndEndStringReversNotLatinLettersInWords_whenSeveralSpacesBeginAndEndStringWordsWithNotLatinLetters() {
        assertEquals("   акортс ловмис  ", anagram.reversesLettersInWords("   строка символ  "));
    }
}