package com.foxminded.lyudmila.integer.division;

public class DivisionContext {
    private final int dividend;
    private final int divisor;
    private final int product;
    private final int dividendLength;
    private int remainderSize;
    private int step;

    public DivisionContext(int dividend, int divisor, int product, int dividendLength) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.product = product;
        this.dividendLength = dividendLength;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getProduct() {
        return product;
    }

    public int getDividendLength() {
        return dividendLength;
    }

    public int getRemainderSize() {
        return remainderSize;
    }

    public void setRemainderSize(int remainderSize) {
        this.remainderSize = remainderSize;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
