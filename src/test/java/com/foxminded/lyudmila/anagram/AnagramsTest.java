package com.foxminded.lyudmila.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {

    @Test
    void reversesLettersInWords_shouldReturnEmptyString_whenEmptyString() {
        String actual = new Anagrams().reversesLettersInWords("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnNull_whenNull() {
        String actual = new Anagrams().reversesLettersInWords(null);
        assertNull(actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSingleSpace_whenSingleSpace() {
        String actual = new Anagrams().reversesLettersInWords(" ");
        String expected = " ";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnAsManySpaces_whenOnlySpaces() {
        String actual = new Anagrams().reversesLettersInWords("   ");
        String expected = "   ";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSingleSymbol_whenSingleSymbol() {
        String actual = new Anagrams().reversesLettersInWords("1");
        String expected = "1";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSameString_whenInputContainsOnlySpacesAndNumbers() {
        String actual = new Anagrams().reversesLettersInWords("  2");
        String expected = "  2";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldLeaveSpacesInPlace_whenInputContainsTwoSpacesBeforeEachWord() {
        String actual = new Anagrams().reversesLettersInWords("  kj2f  fj2k");
        String expected = "  fj2k  kj2f";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSameString_whenInputContainsOnlySameLatter() {
        String actual = new Anagrams().reversesLettersInWords("aaa");
        String expected = "aaa";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseString_whenInputContainOnlySameLatterInLowerAndUpperCases() {
        String actual = new Anagrams().reversesLettersInWords("aAaaa");
        String expected = "aaaAa";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSameString_whenInputContainOnlySameLetterAndNumber() {
        String actual = new Anagrams().reversesLettersInWords("aa2a");
        String expected = "aa2a";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseString_whenInputContainLettersInUpperAndLowerCases() {
        String actual = new Anagrams().reversesLettersInWords("bAcba");
        String expected = "abcAb";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseStringLeaveNumberInPlace_whenInputContainLettersInUpperAndLowerCasesAndNumber() {
        String actual = new Anagrams().reversesLettersInWords("bAca2a");
        String expected = "aacA2b";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseString_whenInputContainDifferentLetters() {
        String actual = new Anagrams().reversesLettersInWords("dcba");
        String expected = "abcd";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSameString_whenInputContainOnlySymbols() {
        String actual = new Anagrams().reversesLettersInWords("+<>");
        String expected = "+<>";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseWordsLeaveNumbersInPlace_whenInputContainSeveralWords() {
        String actual = new Anagrams().reversesLettersInWords("dba fd1s 2gd2f");
        String expected = "abd sd1f 2fd2g";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldLeaveSpacesInPlace_whenInputContainMultipleSpacesBeginAndEndString() {
        String actual = new Anagrams().reversesLettersInWords("   some string   ");
        String expected = "   emos gnirts   ";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseString_whenInputContainNotLatinLetters() {
        String actual = new Anagrams().reversesLettersInWords("????????????");
        String expected = "????????????";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseWords_whenInputContainSeveralWordsWithNotLatinLetters() {
        String actual = new Anagrams().reversesLettersInWords("???????????? ??????????");
        String expected = "???????????? ??????????";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseStringLeaveNumberInPlace_whenInputContainNotLatinLettersAndNumber() {
        String actual = new Anagrams().reversesLettersInWords("????????2????");
        String expected = "????????2????";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnSameString_whenInputContainOnlySameNotLatinLetter() {
        String actual = new Anagrams().reversesLettersInWords("??????");
        String expected = "??????";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseString_whenInputContainOnlySameNotLatterInLowerAndUpperCases() {
        String actual = new Anagrams().reversesLettersInWords("??????????");
        String expected = "??????????";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseStringLeaveSymbolsInPlace_whenInputContainLatinAndNotLatinLettersAndDifferentSymbols() {
        String actual = new Anagrams().reversesLettersInWords("??????5,fff");
        String expected = "fff5,??????";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWords_shouldReturnReverseWordsLeaveSpacesInPlace_whenInputContainMultipleSpacesBeginAndEndStringAndNotLatinLetters() {
        String actual = new Anagrams().reversesLettersInWords("   ???????????? ????????????  ");
        String expected = "   ???????????? ????????????  ";
        assertEquals(expected, actual);
    }

    @Test
    void reversesLettersInWord_ShouldLeaveSymbolsInPlace_whenInputContainBeginSeveralSymbols() {
        String actual = new Anagrams().reversesLettersInWords("$#&jfks");
        String expected = "$#&skfj";
        assertEquals(expected, actual);
    }
}