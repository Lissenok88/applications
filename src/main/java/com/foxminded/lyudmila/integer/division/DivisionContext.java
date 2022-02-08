package com.foxminded.lyudmila.integer.division;

import lombok.Data;

@Data
public class DivisionContext {
    private final int fullDividend;
    private final int divisor;
    private final int quotient;
    private StringBuilder dividend;
    private int dividendNumber;
    private  int productNumber;
    private int step;
}
