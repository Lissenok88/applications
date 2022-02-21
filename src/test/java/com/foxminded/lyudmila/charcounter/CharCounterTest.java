package com.foxminded.lyudmila.charcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/char-counter/severalWords.csv")
    void integerDivisionColumn_shouldReturnUniqueCharacterSet_whenInputSeveralWords(String input, String expected) {
        String actual = new CharCounter().calculateUniqueChars(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/char-counter/sameLatterInUpperAndLowerCase.csv")
    void integerDivisionColumn_shouldReturnCountSameLatterInUpperAndLowerCase_whenInputSameLatterInUpperAndLowerCase(String input, String expected) {
        String actual = new CharCounter().calculateUniqueChars(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/char-counter/severalSpacesBeforeAndEndWords.csv")
    void integerDivisionColumn_shouldReturnCountAllSpaces_whenInputSeveralSpacesBeforeAndEndWords(String input, String expected) {
        String actual = new CharCounter().calculateUniqueChars(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/char-counter/differentSymbols.csv")
    void integerDivisionColumn_shouldReturnCountUniqueSymbols_whenInputDifferentSymbols(String input, String expected) {
        String actual = new CharCounter().calculateUniqueChars(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isIntegerNumber_shouldResultErrorMessage_whenInputNullOrEmptyString(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new CharCounter().calculateUniqueChars(input);
        });
        assertEquals("String is empty or null", thrown.getMessage());
    }
}
