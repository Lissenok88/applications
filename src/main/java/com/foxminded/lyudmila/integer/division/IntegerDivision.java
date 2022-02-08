package com.foxminded.lyudmila.integer.division;

public class IntegerDivision {

    public String integerDivisionColumn(int dividend, int divisor) {
        if (divisor == 0) {
            return "Cannot divide by zero";
        }
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return printWhenResultIsZero(dividend, divisor);
        }
        return divisionColumn(dividend, divisor);
    }

    private String divisionColumn(int fullDividend, int divisor) {
        int quotient = fullDividend / divisor;
        DivisionContext context = new DivisionContext(Math.abs(fullDividend), Math.abs(divisor), quotient);
        StringBuilder result = new StringBuilder();
        String strFullDividend = Integer.toString(context.getFullDividend());
        context.setDividend(new StringBuilder());
        context.setStep(0);

        for (int i = 0; i < strFullDividend.length(); i++) {
            context.getDividend().append(strFullDividend.charAt(i));
            String strDividend = context.getDividend().toString();
            context.setDividendNumber(Integer.parseInt(strDividend));
            if (context.getDividendNumber() >= context.getDivisor()) {
                calculationDivision(context, result);
            } else {
                if (context.getDividendNumber() == 0) {
                    context.setStep(context.getStep() + 1);
                }
            }
        }
        String strDividend = context.getDividend().toString();
        if (Integer.parseInt(strDividend) == 0) {
            context.setStep(context.getStep() - context.getDividend().length());
        }
        printEndLine(context, result);
        return result.toString();
    }

    private void calculationDivision(DivisionContext context, StringBuilder result) {
        int multiplier = context.getDividendNumber() / context.getDivisor();
        context.setProductNumber(context.getDivisor() * multiplier);
        if (result.length() > 0) {
            printStrings(context, result);
        } else {
            printFirstLine(context, result);
            printSecondLine(context, result);
            printThirdLine(context, result);
        }
        context.setStep(context.getStep() + findNumberLength(context.getDividendNumber()));
        context.getDividend().delete(0, context.getDividend().length());
        context.getDividend().append(context.getDividendNumber() - context.getProductNumber());
        if (Integer.parseInt(context.getDividend().toString()) != 0) {
            context.setStep(context.getStep() - context.getDividend().length());
        }
    }

    private int findNumberLength(int number) {
        return (number == 0) ? 1 : (int) Math.log10(number) + 1;
    }

    private void printFirstLine(DivisionContext context, StringBuilder result) {
        result.append("_");
        result.append(context.getFullDividend());
        result.append("|");
        result.append(context.getDivisor());
        result.append("\r\n");
    }

    private void printSecondLine(DivisionContext context, StringBuilder result) {
        int iterator = findNumberLength(context.getFullDividend()) - findNumberLength(context.getProductNumber());
        result.append(" ");
        result.append(context.getProductNumber());
        printSpaces(iterator, result);
        result.append("|---\r\n");
    }

    private void printThirdLine(DivisionContext context, StringBuilder result) {
        int iterator = findNumberLength(context.getFullDividend()) - findNumberLength(context.getProductNumber());
        result.append(" ");
        printDashes(findNumberLength(context.getDividendNumber()), result);
        printSpaces(iterator, result);
        result.append("|");
        result.append(context.getQuotient());
        result.append("\r\n");
    }

    private void printStrings(DivisionContext context, StringBuilder result) {
        int dividendNumLength = findNumberLength(context.getDividendNumber());
        int productNumLength = findNumberLength(context.getProductNumber());
        printSpaces(context.getStep(), result);
        result.append("_");
        result.append(context.getDividendNumber());
        result.append("\r\n" + " ");
        printSpaces(context.getStep(), result);
        printSpaces((dividendNumLength - productNumLength), result);
        result.append(context.getProductNumber());
        result.append("\r\n");
        printSpaces(context.getStep() + 1, result);
        printDashes(dividendNumLength, result);
        result.append("\r\n");
    }

    private void printEndLine(DivisionContext context, StringBuilder result) {
        printSpaces(context.getStep(), result);
        result.append(" ");
        result.append(context.getDividend());
    }

    private String printWhenResultIsZero(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        int dividendLength = findNumberLength(dividend);
        result.append(dividend);
        result.append("|");
        result.append(divisor);
        result.append("\r\n");
        printSpaces(dividendLength, result);
        result.append("|---");
        result.append("\r\n");
        printSpaces(dividendLength, result);
        result.append("|0");
        return result.toString();
    }

    private void printSpaces(int iterator, StringBuilder result) {
        for (int i = 0; i < iterator; i++) {
            result.append(" ");
        }
    }

    private void printDashes(int iterator, StringBuilder result) {
        for (int i = 0; i < iterator; i++) {
            result.append("-");
        }
    }
}
