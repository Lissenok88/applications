package com.foxminded.lyudmila.integer.division;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class IntegerDivisionTest {

    static String[] readingFile(String nameFile) throws IOException {
        FileReader fileReader = new FileReader(nameFile);
        Scanner scanner = new Scanner(fileReader);
        StringBuilder read = new StringBuilder();
        String string;
        while (scanner.hasNextLine()) {
            string = scanner.nextLine();
            if (string.equals("test")) {
                read.delete(read.length() - 1, read.length());
                string = scanner.nextLine();
            }
            read.append(string).append("\n");
        }
        read.delete(read.length() - 1, read.length());
        String[] expected = read.toString().split(",");
        fileReader.close();
        scanner.close();
        return expected;
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnDivisionWithRemainder_whenInputIntegerNumbersData")
    void integerDivisionColumn_shouldReturnDivisionWithRemainder_whenInputIntegerNumbers(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnDivisionWithRemainder_whenInputIntegerNumbersData() throws IOException {
        String[] expected = readingFile("C://Для работы/Разработка/foxidea/src/test/java/testdata/divisionWithRemainder.txt");
        return Stream.of(
            arguments(expected[0], 78945, 14),
            arguments(expected[1], 78945, 4),
            arguments(expected[2], 2147483647, 1256)
        );
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnDivisionWithoutLossZeros_whenInputZerosInDividendEndOrInMiddleData")
    void integerDivisionColumn_shouldReturnDivisionWithoutLossZeros_whenInputZerosInDividendEndOrInMiddle(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnDivisionWithoutLossZeros_whenInputZerosInDividendEndOrInMiddleData() throws IOException {
        String[] expected = readingFile("C://Для работы/Разработка/foxidea/src/test/java/testdata/divisionWithoutLossZeros.txt");
        return Stream.of(
            arguments(expected[0], 58000, 3),
            arguments(expected[1], 50005, 5),
            arguments(expected[2], 5005005, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnDivisionWithoutRemainder_whenInputIntegerNumbersData")
    void integerDivisionColumn_shouldReturnDivisionWithoutRemainder_whenInputIntegerNumbers(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnDivisionWithoutRemainder_whenInputIntegerNumbersData() throws IOException {
        String[] expected = readingFile("C://Для работы/Разработка/foxidea/src/test/java/testdata/divisionWithoutRemainder.txt");
        return Stream.of(
            arguments(expected[0], 44, 4),
            arguments(expected[1], 44, 44),
            arguments(expected[2], 2568, 24),
            arguments(expected[3], 81625, 125)
        );
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnZero_whenInputDividendLessThenDivisorData")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendLessThenDivisor(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnZero_whenInputDividendLessThenDivisorData() throws IOException {
        String[] expected = readingFile("C://Для работы/Разработка/foxidea/src/test/java/testdata/dividendLessThenDivisor.txt");
        return Stream.of(
            arguments(expected[0], 4, 44),
            arguments(expected[1], 2567, 3659),
            arguments(expected[2], 12, 5893),
            arguments(expected[3], 0, 65)
        );
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnDivisionModule_whenInputDividendOrDivisorLessZeroData")
    void integerDivisionColumn_shouldReturnDivisionModule_whenInputDividendOrDivisorLessZero(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnDivisionModule_whenInputDividendOrDivisorLessZeroData() throws IOException {
        String[] expected = readingFile("C://Для работы/Разработка/foxidea/src/test/java/testdata/dividendOrDivisorLessZero.txt");
        return Stream.of(
            arguments(expected[0], -44, 3),
            arguments(expected[1], 1365, -26),
            arguments(expected[2], -37569, -146)
        );
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnZero_whenInputDividendZeroData")
    void integerDivisionColumn_shouldReturnZero_whenInputDividendZero(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnZero_whenInputDividendZeroData() throws IOException {
        String[] expected = readingFile("C://Для работы/Разработка/foxidea/src/test/java/testdata/dividendZero.txt");
        return Stream.of(
            arguments(expected[0], 0, 44),
            arguments(expected[1], 0, 2568)
        );
    }

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnErrorMessage_whenInputDivisorZeroData")
    void integerDivisionColumn_shouldReturnErrorMessage_whenInputDivisorZero(String expected, int param1, int param2) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnErrorMessage_whenInputDivisorZeroData() {
        String expected = "Cannot divide by zero";
        return Stream.of(
            arguments(expected, 44, 0),
            arguments(expected, 0, 0),
            arguments(expected, 12365, 0)
        );
    }
}
