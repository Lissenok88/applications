package com.foxminded.lyudmila.IntegerDivision;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class VerificationTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void checkingStringOnIntNumber_shouldResultNullOrEmptyString_whenParameterNullOrEmptyStrings(String text) {
        String actual = Verification.checkingStringOnIntNumber(text);
        assertTrue(actual == null || actual.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("checkingStringOnIntNumber_shouldResultEmptyStringOrDijit_whenDifferentParameterData")
    void checkingStringOnIntNumber_shouldResultEmptyStringOrDijit_whenDifferentParameter(String expected, String string) {
        String actual = Verification.checkingStringOnIntNumber(string);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> checkingStringOnIntNumber_shouldResultEmptyStringOrDijit_whenDifferentParameterData() {
        return Stream.of(
            arguments("-256", "-256"),
            arguments("-56", "-00056"),
            arguments("", ""),
            arguments("", "dfdfd"),
            arguments("56", "000056"),
            arguments("2147483647", "2147483647"),
            arguments("", "2147483648"),
            arguments("-2147483648", "-2147483648"),
            arguments("", "-2147483649"),
            arguments("", "--4546"),
            arguments("", "34!$23"),
            arguments("", "DDeffd536"),
            arguments("564654", "564654")
        );
    }
}
