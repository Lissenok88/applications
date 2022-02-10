package com.foxminded.lyudmila.integer.division;

import lombok.Data;

@Data
public class DivisionContext {
    private final int dividend;
    private final int divisor;
    private final int product;
    private final int dividendLength;
    private int remainderSize;
    private int step;
}
