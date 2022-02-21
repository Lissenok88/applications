package com.foxminded.lyudmila.charcounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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
    void getUniqueChars_shouldMethodCalculateUniqueCharsUsedOnce_whenCacheIsEmpty() {
        assertNull(cashingCharCounter.cache.getIfPresent(actual));
        cashingCharCounter.getUniqueChars(actual);
        assertEquals(expected, cashingCharCounter.cache.getIfPresent(actual));
    }

    @Test
    void getUniqueChars_shouldMethodCalculateUniqueCharsNotUsed_whenInputValueInCache() {
        cashingCharCounter.cache.put(actual, expected);
        assertEquals(expected, cashingCharCounter.cache.getIfPresent(actual));
        cashingCharCounter.getUniqueChars(actual);
        assertEquals(expected, cashingCharCounter.cache.getIfPresent(actual));
    }

    @Test
    void cashingCharCounter_shouldMethodCalculateUniqueCharsNotUsed_whenInputValueInCache() {
        cashingCharCounter.cache.put(actual, expected);
        cashingCharCounter.cache.get(actual, key -> charCounter.calculateUniqueChars(actual));
        Mockito.verify(charCounter, Mockito.times(0)).calculateUniqueChars(actual);
    }

    @Test
    void cashingCharCounter_shouldMethodCalculateUniqueCharsUsedOnce_whenCacheIsEmpty() {
        Mockito.when(charCounter.calculateUniqueChars(actual)).thenReturn(expected);
        cashingCharCounter.cache.get(actual, key -> charCounter.calculateUniqueChars(actual));
        cashingCharCounter.cache.get(actual, key -> charCounter.calculateUniqueChars(actual));
        Mockito.verify(charCounter, Mockito.times(1)).calculateUniqueChars(actual);
    }

    /*   @Test
    void cashingCharCounter_shouldMethodCalculateUniqueCharsUsedOnce_whenCacheIsEmpty1() {
        Mockito.when(charCounter.calculateUniqueChars(actual)).thenReturn(expected);
        cashingCharCounter.getUniqueChars(actual);
        Mockito.verify(charCounter, Mockito.times(1)).calculateUniqueChars(actual);
    }
*/

}
