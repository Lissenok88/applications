package com.foxminded.lyudmila.integer.division;

import java.util.stream.IntStream;

public class IntegerDivision {

    public String integerDivisionColumn(int dividend, int divisor) {
        if (divisor == 0) {
            return "Cannot divide by zero";
        }
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return formResultWhenResultIsZero(dividend, divisor);
        }
        return divisionColumn(dividend, divisor);
    }

    private String divisionColumn(int dividend, int divisor) {
        DivisionContext context = new DivisionContext();
        context.setProduct(dividend / divisor);
        context.setDividend(Math.abs(dividend));
        context.setDivisor(Math.abs(divisor));
        context.setDividendLength((int) Math.log10(context.getDividend()) + 1);
        int[] productDigits = splitToDigits(context.getProduct());
        int[] remainders = new int[productDigits.length];
        remainders[0] = (context.getDividend() % context.getDivisor()) * 10;
        for (int i = 1; i < remainders.length; i++) {
            remainders[i] = (productDigits[i - 1] * context.getDivisor()) + (remainders[i - 1] / 10);
        }
        return formResult(productDigits, remainders, context);
    }

    private int[] splitToDigits(int number) {
        return IntStream.iterate(Math.abs(number), i -> i > 0, i -> i / 10).map(i -> i % 10).toArray();
    }

    private String formResult(int[] productDigits, int[] remainders, DivisionContext context) {
        StringBuilder result = new StringBuilder();
        int subtrahend = productDigits[productDigits.length - 1] * context.getDivisor();

        addFirstLine(context, result);
        addSecondLine(context, result, subtrahend);
        addThirdLine(context, result);
        for (int i = remainders.length - 1; i > 0; i--) {
            if (productDigits[i - 1] == 0) {
                continue;
            }
            subtrahend = context.getDivisor() * productDigits[i - 1];
            context.setStep(context.getDividendLength() - i + 1);
            addReminder(context, remainders[i], result);
            addSubtrahend(context, subtrahend, result);
            addSeparator(context, result);
        }
        addLastLine(context, result);
        return result.toString();
    }

    private void addFirstLine(DivisionContext context, StringBuilder result) {
        result.append("_");
        result.append(context.getDividend());
        result.append("|");
        result.append(context.getDivisor());
        result.append("\r\n");
    }

    private void addSecondLine(DivisionContext context, StringBuilder result, int subtrahend) {
        result.append(" ");
        context.setStep(result.length());
        result.append(subtrahend);
        context.setStep(context.getDividendLength() - (result.length() - context.getStep()));
        addSpaces(context.getStep(), result);
        result.append("|---\r\n");
    }

    private void addThirdLine(DivisionContext context, StringBuilder result) {
        result.append(" ");
        addDashes(context.getDividendLength() - context.getStep(), result);
        addSpaces(context.getStep(), result);
        result.append("|");
        result.append(context.getProduct());
        result.append("\r\n");
    }

    private void addReminder(DivisionContext context, int remainder, StringBuilder result) {
        result.append("_");
        context.setRemainderSize(result.length());
        result.append(remainder);
        context.setRemainderSize(result.length() - context.getRemainderSize());
        context.setStep(context.getStep() - context.getRemainderSize());
        addSpaces(context.getStep(), result, result.length() - context.getRemainderSize() - 1);
        result.append("\r\n ");
    }

    private void addSubtrahend(DivisionContext context, int subtrahend, StringBuilder result) {
        int subtrahendSize = result.length();
        result.append(subtrahend);
        subtrahendSize = result.length() - subtrahendSize;
        int spacesCount = context.getStep() + context.getRemainderSize() - subtrahendSize;
        addSpaces(spacesCount, result, result.length() - subtrahendSize);
        result.append("\r\n");
    }

    private void addSeparator(DivisionContext context, StringBuilder result) {
        addSpaces(context.getStep() + 1, result);
        addDashes(context.getRemainderSize(), result);
        result.append("\r\n");
    }

    private void addLastLine(DivisionContext context, StringBuilder result) {
        int remainder = context.getDividend() % context.getDivisor();
        context.setRemainderSize(result.length());
        result.append(remainder);
        context.setRemainderSize(result.length() - context.getRemainderSize());
        int spacesCount = context.getDividendLength() - context.getRemainderSize() + 1;
        addSpaces(spacesCount, result, result.length() - context.getRemainderSize());
    }

    private String formResultWhenResultIsZero(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();

        result.append(dividend);
        int dividendLength = result.length();
        result.append("|");
        result.append(divisor);
        result.append("\r\n");

        addSpaces(dividendLength, result);
        result.append("|---\r\n");

        addSpaces(dividendLength, result);
        result.append("|0");
        return result.toString();
    }

    private void addSpaces(int count, StringBuilder result) {
        result.append(" ".repeat(Math.max(0, count)));
    }

    private void addSpaces(int count, StringBuilder result, int index) {
        result.insert(index, " ".repeat(Math.max(0, count)));
    }

    private void addDashes(int count, StringBuilder result) {
        result.append("-".repeat(Math.max(0, count)));
    }
}
