package com.foxminded.lyudmila.formula1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class Formula1Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/formula1/test-empty-file/testEmptyFile.csv")
    void formula1_shouldResultErrorMessage_whenInputEmptyFile(String abbreviations, String startMoments, String finishMoments, String expected) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Formula1().formula1(startMoments, finishMoments, abbreviations);
        });
        assertEquals(expected, thrown.getMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/formula1/test-wrong-data-time-format/testWrongDataTimeFormat.csv")
    void formula1_shouldResultErrorMessage_whenInputWrongDataTimeFormat(String abbreviations, String startMoments, String finishMoments) {
        assertThrows(DateTimeParseException.class, () -> {
            new Formula1().formula1(startMoments, finishMoments, abbreviations);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/formula1/test-incorrect-racer-data-format/testIncorrectRacerDataFormat.csv")
    void formula1_shouldResultErrorMessage_whenInputIncorrectRacerDataFormat(String abbreviations, String startMoments, String finishMoments) {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new Formula1().formula1(startMoments, finishMoments, abbreviations);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/formula1/test-non-existent-abbreviation/testNonExistentAbbreviation.csv")
    void formula1_shouldResultOnlyForExistingAbbreviations_whenInputNonExistentAbbreviation(String abbreviations, String startMoments, String finishMoments, String expected) {
        String actual = new Formula1().formula1(startMoments, finishMoments, abbreviations);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/formula1/test-abbreviation-in-lower-case/testAbbreviationInLowerCase.csv")
    void formula1_shouldResultWithoutMistakesAndAbbreviationInUpperCase_whenInputAbbreviationInLowerCase(String abbreviations, String startMoments, String finishMoments, String expected) {
        String actual = new Formula1().formula1(startMoments, finishMoments, abbreviations);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/formula1/test-file-is-null/testFileIsNull.csv")
    void formula1_shouldResultErrorMessage_whenFileISNull(String abbreviations, String startMoments, String finishMoments, String expected) {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            new Formula1().formula1(startMoments, finishMoments, abbreviations);
        });
        assertEquals(expected, thrown.getMessage());
    }
}
