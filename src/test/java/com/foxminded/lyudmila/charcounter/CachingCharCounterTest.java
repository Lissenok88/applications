package com.foxminded.lyudmila.charcounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachingCharCounterTest {
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
    CharCounter charCounter;

    @Test
    void cachingCharCounter_shouldMethodCalculateUniqueCharsNotUsed_whenInputValueInCache() {
        CachingCharCounter cachingCharCounter = new CachingCharCounter(charCounter);
        Mockito.when(charCounter.calculateUniqueChars(actual)).thenReturn(expected);
        cachingCharCounter.getUniqueChars(actual);
        cachingCharCounter.getUniqueChars(actual);
        cachingCharCounter.getUniqueChars(actual);
        Mockito.verify(charCounter, Mockito.times(1)).calculateUniqueChars(actual);
    }
}
