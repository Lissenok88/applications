package com.foxminded.lyudmila.integer.division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionWithRemainder.csv")
    void integerDivisionColumn_shouldReturnDivisionWithRemainder_whenInputAnyNumber(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionWithoutLossZeros.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutLossZeros_whenInputZerosInDividendEndOrInMiddle(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionWithoutRemainder.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutRemainder_whenInputAnyNumber(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dividendLessThenDivisor.csv")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendLessThenDivisor(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dividendOrDivisorLessZero.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutLossOfSign_whenInputDividendOrDivisorLessZero(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dividendZero.csv")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendZero(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisorZero.csv")
    void integerDivisionColumn_shouldReturnErrorMessage_whenInputDivisorZero(int dividend, int divisor, String expected) {
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            new IntegerDivision().integerDivisionColumn(dividend, divisor);
        });
        assertEquals(expected, thrown.getMessage());
    }
}
