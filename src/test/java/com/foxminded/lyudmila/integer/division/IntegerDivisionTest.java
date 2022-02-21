package com.foxminded.lyudmila.integer.division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/divisionWithRemainder.csv")
    void integerDivisionColumn_shouldReturnDivisionWithRemainder_whenInputAnyNumber(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/divisionWithoutLossZeros.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutLossZeros_whenInputZerosInDividendEndOrInMiddle(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/divisionWithoutRemainder.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutRemainder_whenInputAnyNumber(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/dividendLessThenDivisor.csv")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendLessThenDivisor(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/dividendOrDivisorLessZero.csv")
    void integerDivisionColumn_shouldReturnDivisionWithoutLossOfSign_whenInputDividendOrDivisorLessZero(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/dividendZero.csv")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendZero(int dividend, int divisor, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/integer-division/divisorZero.csv")
    void integerDivisionColumn_shouldReturnErrorMessage_whenInputDivisorZero(int dividend, int divisor, String expected) {
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            new IntegerDivision().integerDivisionColumn(dividend, divisor);
        });
        assertEquals(expected, thrown.getMessage());
    }
}
