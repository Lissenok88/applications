package com.foxminded.lyudmila.charcounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CashingCharCounterTest {
    private final String actual = "hello world";

    private final String expected = "\"h\" - 1\r\n" +
        "\"e\" - 1\r\n" +
        "\"l\" - 3\r\n" +
        "\"o\" - 2\r\n" +
        "\" \" - 1\r\n" +
        "\"w\" - 1\r\n" +
        "\"r\" - 1\r\n" +
        "\"d\" - 1";

    @Mock
    CharCounter charCounter = new CharCounter();

    @InjectMocks
    CashingCharCounter cashingCharCounter = new CashingCharCounter();

    @Test
    void cashingCharCounter_shouldMethodCalculateUniqueCharsNotUsed_whenInputValueInCache() {
        cashingCharCounter.getCache().put(actual, expected);
        cashingCharCounter.getCache().get(actual, key -> charCounter.calculateUniqueChars(actual));
        Mockito.verify(charCounter, Mockito.times(0)).calculateUniqueChars(actual);
    }

    @Test
    void cashingCharCounter_shouldMethodCalculateUniqueCharsUsedOnce_whenCacheIsEmpty() {
        Mockito.when(charCounter.calculateUniqueChars(actual)).thenReturn(expected);
        cashingCharCounter.getCache().get(actual, key -> charCounter.calculateUniqueChars(actual));
        cashingCharCounter.getCache().get(actual, key -> charCounter.calculateUniqueChars(actual));
        Mockito.verify(charCounter, Mockito.times(1)).calculateUniqueChars(actual);
    }
}
