package com.foxminded.lyudmila.IntegerDivision;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class IntegerDivisionTest {

    @ParameterizedTest
    @MethodSource("integerDivisionColumn_shouldReturnColumnDivision_whenParamsIntegersData")
    void integerDivisionColumn_shouldReturnColumnDivision_whenParamsIntegers(int param1, int param2, String expected) {
        String actual = new IntegerDivision().integerDivisionColumn(param1, param2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerDivisionColumn_shouldReturnColumnDivision_whenParamsIntegersData() {
        return Stream.of(
            arguments(78945, 14, "_78945|14\n" +
                " 70   |----\n" +
                " --   |5638\n" +
                " _89\n" +
                "  84\n" +
                "  --\n" +
                "  _54\n" +
                "   42\n" +
                "   --\n" +
                "  _125\n" +
                "   112\n" +
                "   ---\n" +
                "    13"),
            arguments(78945, 4, "_78945|4\n" +
                " 4    |-----\n" +
                " -    |19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1"),
            arguments(44, 4, "_44|4\n" +
                " 4 |--\n" +
                " - |11\n" +
                " _4\n" +
                "  4\n" +
                "  -\n" +
                "  0"),
            arguments(4, 44, "4|44\n" +
                " |--\n" +
                " |0"),
            arguments(44, 0, "Cannot divide by zero"),
            arguments(0, 0, "Cannot divide by zero"),
            arguments(44, 44, "_44|44\n" +
                " 44|-\n" +
                " --|1\n" +
                "  0"),
            arguments(2147483647, 1256, "_2147483647|1256\n" +
                " 1256      |------\n" +
                " ----      |179779\n" +
                " _8914\n" +
                "  8792\n" +
                "  ----\n" +
                "  _12283\n" +
                "   11304\n" +
                "   -----\n" +
                "    _9796\n" +
                "     8792\n" +
                "     ----\n" +
                "    _10044\n" +
                "      8792\n" +
                "     -----\n" +
                "     _12527\n" +
                "      11304\n" +
                "      -----\n" +
                "       1223"),
            arguments(-44, 3, "_44|3\n" +
                " 3 |--\n" +
                " - |14\n" +
                "_14\n" +
                " 12\n" +
                " --\n" +
                "  2"),
            arguments(0, 44, "0|44\n" +
                " |--\n" +
                " |0"),
            arguments(58000, 3, "_58000|3\n" +
                " 3    |-----\n" +
                " -    |19333\n" +
                "_28\n" +
                " 27\n" +
                " --\n" +
                " _10\n" +
                "   9\n" +
                "  --\n" +
                "  _10\n" +
                "    9\n" +
                "   --\n" +
                "   _10\n" +
                "     9\n" +
                "    --\n" +
                "     1"),
            arguments(500005, 5, "_500005|5\n" +
                " 5     |------\n" +
                " -     |100001\n" +
                "     _5\n" +
                "      5\n" +
                "      -\n" +
                "      0"),
            arguments(5005005, 5, "_5005005|5\n" +
                " 5      |-------\n" +
                " -      |1001001\n" +
                "   _5\n" +
                "    5\n" +
                "    -\n" +
                "      _5\n" +
                "       5\n" +
                "       -\n" +
                "       0")
        );
    }
}
