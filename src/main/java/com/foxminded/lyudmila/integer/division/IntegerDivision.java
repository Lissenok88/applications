package com.foxminded.lyudmila.integer.division;

import java.util.ArrayList;

public class IntegerDivision {
    private final ArrayList<String> result = new ArrayList<>();
    private final StringBuilder quotient = new StringBuilder();
    private int step = 0;

    public String integerDivisionColumn(int fullDividend, int divisor) {
        if (divisor == 0) {
            return "Cannot divide by zero";
        }
        fullDividend = Math.abs(fullDividend);
        divisor = Math.abs(divisor);
        if (fullDividend < divisor) {
            return formationResultWhenDividendZero(fullDividend, divisor);
        }
        StringBuilder dividendDigits = new StringBuilder(Integer.toString(fullDividend));
        return divisionColumn(dividendDigits, divisor);

    }

    private String divisionColumn(StringBuilder dividendDigits, int divisor) {
        StringBuilder dividend = new StringBuilder();
        int dividendNumber;
        int count = 0;

        for (int i = 0; i < dividendDigits.length(); i++) {
            dividend.append(dividendDigits.charAt(i));
            dividendNumber = Integer.parseInt(dividend.toString());
            if (dividendNumber >= divisor) {
                dividend.delete(0, dividend.length());
                dividend.append(calculationDivision(dividendNumber, divisor, dividendDigits));
                count = 0;
            } else {
                count++;
                if (dividendNumber == 0 && i < dividendDigits.length()) {
                    quotient.append(0);
                    step++;
                } else {
                    if (count > 0 && result.size() > 1) quotient.append(0);
                }
            }
        }
        modificationFirstStrings(dividend);
        return convertingArrayListInString(result);
    }

    private String calculationDivision(int dividendNumber, int divisor, StringBuilder dividendDigits) {
        StringBuilder dividend = new StringBuilder();
        int multiplier = dividendNumber / divisor;
        int productNumber = divisor * multiplier;
        if (result.size() > 1) {
            formationStrings(dividendNumber, productNumber, step);
            quotient.append(multiplier);
        } else {
            formationFirstStrings(dividendDigits, dividendNumber, productNumber, divisor);
            quotient.append(multiplier);
        }
        step += Integer.toString(dividendNumber).length();
        dividend.append(dividendNumber - productNumber);
        if (Integer.parseInt(dividend.toString()) != 0) {
            step -= dividend.length();
        }
        return dividend.toString();
    }

    private void formationFirstStrings(StringBuilder dividendDigits, int dividendNum, int productNum, int divisor) {
        String spaces = countSpaces(dividendDigits.length() - Integer.toString(productNum).length());
        String dash = countDash(Integer.toString(dividendNum).length());
        result.add("_" + dividendDigits + "|" + divisor + "\n");
        result.add(" " + productNum + spaces + "|");
        result.add(" " + dash + spaces + "|");
    }

    private void formationStrings(int dividendNumber, int productNumber, int step) {
        int sizeDividendNumber = Integer.toString(dividendNumber).length();
        int sizeProductNumber = Integer.toString(productNumber).length();
        String spaces = countSpaces(sizeDividendNumber - sizeProductNumber);
        String dash = countDash(sizeDividendNumber);
        result.add(countSpaces(step) + "_" + dividendNumber + "\n");
        result.add(countSpaces(step + 1) + spaces + productNumber + "\n");
        result.add(countSpaces(step + 1) + dash + "\n");
    }

    private void modificationFirstStrings(StringBuilder dividend) {
        if (Integer.parseInt(dividend.toString()) == 0) {
            step -= dividend.length();
        }
        result.add(countSpaces(step) + " " + dividend);
        result.set(1, result.get(1) + countDash(quotient.length()) + "\n");
        result.set(2, result.get(2) + quotient + "\n");
    }

    private String convertingArrayListInString(ArrayList<String> arrayData) {
        StringBuilder result = new StringBuilder();
        for (String str : arrayData) {
            result.append(str);
        }
        return result.toString();
    }

    private String formationResultWhenDividendZero(int dividend, int divisor) {
        String dash = countDash(Integer.toString(divisor).length());
        String spaces = countSpaces(Integer.toString(dividend).length());

        result.add(dividend + "|" + divisor + "\n");
        result.add(spaces + "|" + dash + "\n");
        result.add(spaces + "|0");

        return convertingArrayListInString(result);
    }

    private String countSpaces(int iterator) {
        int i = 1;
        StringBuilder spaces = new StringBuilder();
        while (i <= iterator) {
            spaces.append(" ");
            i++;
        }
        return spaces.toString();
    }

    private String countDash(int iterator) {
        int i = 1;
        StringBuilder dash = new StringBuilder();
        while (i <= iterator) {
            dash.append("-");
            i++;
        }
        return dash.toString();


    }

}
