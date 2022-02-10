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
        final int product = dividend / divisor;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        final int dividendSize = (int) Math.log10(dividend) + 1;
        final int[] productDigits = splitToDigits(product);
        final int[] remainders = new int[productDigits.length];
        remainders[0] = (dividend % divisor) * 10;
        for (int i = 1; i < remainders.length; i++) {
            remainders[i] = (productDigits[i - 1] * divisor) + (remainders[i - 1] / 10);
        }
        DivisionContext context = new DivisionContext(dividend, divisor, product, dividendSize);

        return formResult(productDigits, remainders, context);
    }

    private int[] splitToDigits(final int number) {
        return IntStream.iterate(Math.abs(number), i -> i > 0, i -> i / 10).map(i -> i % 10).toArray();
    }

    private String formResult(final int[] productDigits, final int[] remainders, DivisionContext context) {
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

    private void addSecondLine(DivisionContext context, StringBuilder result, final int subtrahend) {
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

    private void addReminder(DivisionContext context, final int remainder, StringBuilder result) {
        result.append("_");
        context.setRemainderSize(result.length());
        result.append(remainder);
        context.setRemainderSize(result.length() - context.getRemainderSize());
        context.setStep(context.getStep() - context.getRemainderSize());
        addSpaces(context.getStep(), result, result.length() - context.getRemainderSize() - 1);
        result.append("\r\n ");
    }

    private void addSubtrahend(DivisionContext context, final int subtrahend, StringBuilder result) {
        int subtrahendSize = result.length();
        result.append(subtrahend);
        subtrahendSize = result.length() - subtrahendSize;
        final int spacesCount = context.getStep() + context.getRemainderSize() - subtrahendSize;
        addSpaces(spacesCount, result, result.length() - subtrahendSize);
        result.append("\r\n");
    }

    private void addSeparator(DivisionContext context, StringBuilder result) {
        addSpaces(context.getStep() + 1, result);
        addDashes(context.getRemainderSize(), result);
        result.append("\r\n");
    }

    private void addLastLine(DivisionContext context, StringBuilder result) {
        final int remainder = context.getDividend() % context.getDivisor();
        context.setRemainderSize(result.length());
        result.append(remainder);
        context.setRemainderSize(result.length() - context.getRemainderSize());
        final int spacesCount = context.getDividendLength() - context.getRemainderSize() + 1;
        addSpaces(spacesCount, result, result.length() - context.getRemainderSize());
    }

    private String formResultWhenResultIsZero(final int dividend, int divisor) {
        StringBuilder result = new StringBuilder();

        result.append(dividend);
        final int dividendLength = result.length();
        result.append("|");
        result.append(divisor);
        result.append("\r\n");

        addSpaces(dividendLength, result);
        result.append("|---\r\n");

        addSpaces(dividendLength, result);
        result.append("|0");
        return result.toString();
    }

    private void addSpaces(final int count, StringBuilder result) {
        result.append(" ".repeat(Math.max(0, count)));
    }

    private void addSpaces(final int count, StringBuilder result, final int index) {
        result.insert(index, " ".repeat(Math.max(0, count)));
    }

    private void addDashes(final int count, StringBuilder result) {
        result.append("-".repeat(Math.max(0, count)));
    }
}
