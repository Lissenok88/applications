package com.foxminded.lyudmila.integer.division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionWithRemainder.csv")
    void integerDivisionColumn_shouldReturnDivisionWithRemainder_whenInputIntegerNumbers(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionWithoutLossZeros.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutLossZeros_whenInputZerosInDividendEndOrInMiddle(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionWithoutRemainder.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutRemainder_whenInputIntegerNumbers(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dividendLessThenDivisor.csv")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendLessThenDivisor(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dividendOrDivisorLessZero.csv")
    void integerDivisionColumn_shouldReturnDivisionModule_whenInputDividendOrDivisorLessZero(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dividendZero.csv")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendZero(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisorZero.csv")
    void integerDivisionColumn_shouldReturnErrorMessage_whenInputDivisorZero(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }
}
