import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    Anagrams anagram = new Anagrams();

    @Test
    void givenSeveralSpaces_whenReversesLettersInWords_thenSeveralSpaces() {
        assertEquals("   ", anagram.reversesLettersInWords("   "));
    }

    @Test
    void givenSingleCharacter_whenReversesLettersInWords_thenSingleCharacter() {
        assertEquals("1", anagram.reversesLettersInWords("1"));
    }

    @Test
    void givenSeveralIdenticalLetters_whenReversesLettersInWords_thenSeveralIdentical() {
        assertEquals("aaa", anagram.reversesLettersInWords("aaa"));
    }

    @Test
    void givenSameUpperAndLowerLettersMixed_whenReversesLettersInWords_thenSameUpperAndLowerLettersMixed() {
        assertEquals("abcAb", anagram.reversesLettersInWords("bAcba"));
    }

    @Test
    void givenDifferentLetters_whenReversesLettersInWords_thenDifferentLetters() {
        assertEquals("abcd", anagram.reversesLettersInWords("dcba"));
    }

    @Test
    void givenOnlySymbols_ReversesLettersInWords_thenOnlySymbols() {
        assertEquals("+<>", anagram.reversesLettersInWords("+<>"));
    }

    @Test
    void givenFewWords_whenReversesLettersInWords_thenFewWords() {
        assertEquals("abd sd1f 2fd2g", anagram.reversesLettersInWords("dba fd1s 2gd2f"));
    }

    @Test
    void givenTwoSpacesAndSymbol_whenReversesLettersInWords_thenTwoSpacesAndSymbol() {
        assertEquals("  2", anagram.reversesLettersInWords("  2"));
    }

    @Test
    void givenEmptyString_whenReversesLettersInWords_thenEmptyString() {
        assertEquals("", anagram.reversesLettersInWords(""));
    }

    @Test
    void givenSingleSpace_whenReversesLettersInWords_thenSingleSpace() {
        assertEquals(" ", anagram.reversesLettersInWords(" "));
    }
}