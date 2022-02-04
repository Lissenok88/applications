package com.foxminded.lyudmila.integer.division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class VerificationTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n", ""})
    void isIntegerNumber_shouldResultFalse_whenNullOrEmptyStrings(String text) {
        Boolean actual = Verification.isIntegerNumber(text);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dfdf", "2147483648", "-2147483649", "--4546", "34!$23", "DDeffd536"})
    void isIntegerNumber_shouldResultFalse_whenInputNotIntegerNumber(String text) {
        Boolean actual = Verification.isIntegerNumber(text);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-256", "-00056", "000566", "2147483647", "-2147483648", "4646", "000"})
    void isIntegerNumber_shouldResultTrue_whenInputIntegerNumber(String text) {
        Boolean actual = Verification.isIntegerNumber(text);
        assertTrue(actual);
    }
}
