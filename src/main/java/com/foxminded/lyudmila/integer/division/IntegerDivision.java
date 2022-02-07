package com.foxminded.lyudmila.integer.division;

public class IntegerDivision {
    public String integerDivisionColumn(int dividend, int divisor) {
        if (isIntegerZero(divisor)) {
            return "Cannot divide by zero";
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) {
            return formationResultWhenResultIsZero(dividend, divisor);
        }
        return divisionColumn(dividend, divisor);

    }

    private String divisionColumn(int fullDividend, int divisor) {
        StringBuilder dividend = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int dividendNumber;
        int step = 0;
        int count = 0;

        createdFirstString(fullDividend, divisor, result);
        int length = result.length();
        for (int i = 0; i < Integer.toString(fullDividend).length(); i++) {
            dividend.append(Integer.toString(fullDividend).charAt(i));
            dividendNumber = Integer.parseInt(dividend.toString());
            if (dividendNumber >= divisor) {
                result.append(step + "\r\n");
                result.append(length);
                dividend.delete(0, dividend.length());
                dividend.append(calculationDivision(dividendNumber, divisor, result));
                step = searchStep(result);
                result.delete(result.length() - Integer.toString(step).length() - 1, result.length());
                result.append("\n");
                count = 0;
            } else {
                count++;
                if (dividendNumber == 0 && i < Integer.toString(fullDividend).length()) {
                    updateFirstStrings(0, result);
                    step++;
                } else {
                    if (count > 0 && step > 0 && result.length() > 1) updateFirstStrings(0, result);
                }
            }
        }
        if (Integer.parseInt(dividend.toString()) == 0) {
            step -= dividend.length();
        }
        addSpaces(step, result);
        result.append(" " + dividend);
        return result.toString();
    }

    private String calculationDivision(int dividendNumber, int divisor, StringBuilder result) {
        StringBuilder dividend = new StringBuilder();
        int length = searchLength(result) + 1;
        int multiplier = dividendNumber / divisor;
        int productNumber = divisor * multiplier;
        int step = searchStep(result);
        if (result.length() > length) {
            formationStrings(dividendNumber, productNumber, result);
            updateFirstStrings(multiplier, result);
        } else {
            formationFirstStrings(dividendNumber, productNumber, result);
            updateFirstStrings(multiplier, result);
        }
        step += Integer.toString(dividendNumber).length();
        dividend.append(dividendNumber - productNumber);
        if (Integer.parseInt(dividend.toString()) != 0) {
            step -= dividend.length();
        }
        result.append(step);
        return dividend.toString();
    }

    private void createdFirstString(int fullDividend, int divisor, StringBuilder result) {
        result.append("_" + fullDividend + "|" + divisor + "\r\n");
        addSpaces(Integer.toString(fullDividend).length() + 1, result);
        result.append("|\r\n");
        addSpaces(Integer.toString(fullDividend).length() + 1, result);
        result.append("|\r\n");
    }

    private void formationFirstStrings(int dividendNum, int productNum, StringBuilder result) {
        int step = searchStep(result);
        result.delete(result.length() - Integer.toString(step).length() - 1, result.length());
        result.append("\n");
        int[] index = searchFirstStrings(result);
        int j = index[0] + 2 + Integer.toString(productNum).length();
        result.replace(index[0] + 2, j, Integer.toString(productNum));
        String dash = countDashes(Integer.toString(dividendNum).length());
        j = index[1] + 2 + Integer.toString(dividendNum).length();
        result.replace(index[1] + 2, j, dash);
    }

    private void updateFirstStrings(int multiplier, StringBuilder result) {
        int[] index = searchFirstStrings(result);
        result.insert(index[1] - 1, countDashes(Integer.toString(multiplier).length()));
        result.insert(index[2], multiplier);
    }

    private void formationStrings(int dividendNum, int productNum, StringBuilder result) {
        int sizeDividendNum = Integer.toString(dividendNum).length();
        int sizeProductNum = Integer.toString(productNum).length();
        int step = searchStep(result);
        result.delete(result.length() - Integer.toString(step).length() - 1, result.length());
        result.append("\n");
        addSpaces(step, result);
        result.append("_" + dividendNum + "\r\n" + " ");
        addSpaces(step, result);
        addSpaces((sizeDividendNum - sizeProductNum), result);
        result.append(productNum + "\r\n");
        addSpaces(step + 1, result);
        addDashes(sizeDividendNum, result);
        result.append("\r\n");
    }

    private String formationResultWhenResultIsZero(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        result.append(dividend + "|" + divisor + "\r\n");
        addSpaces(Integer.toString(dividend).length(), result);
        result.append("|");
        addDashes(Integer.toString(divisor).length(), result);
        result.append("\r\n");
        addSpaces(Integer.toString(dividend).length(), result);
        result.append("|0");
        return result.toString();
    }

    private int[] searchFirstStrings(StringBuilder result) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        return index;
    }

    private int searchStep(StringBuilder result) {
        int i = result.lastIndexOf("\r\n");
        String step = result.substring(i + 2);
        return Integer.parseInt(step);
    }

    private int searchLength(StringBuilder result) {
        String length;
        int i = result.lastIndexOf("\r\n");
        length = result.substring(i + 2);
        result.delete(i, result.length());
        return Integer.parseInt(length);
    }

    private void addSpaces(int iterator, StringBuilder result) {
        for (int i = 0; i < iterator; i++) {
            result.append(" ");
        }
    }

    private void addDashes(int iterator, StringBuilder result) {
        for (int i = 0; i < iterator; i++) {
            result.append("-");
        }
    }

    private String countDashes(int iterator) {
        int i = 1;
        StringBuilder dash = new StringBuilder();
        while (i <= iterator) {
            dash.append("-");
            i++;
        }
        return dash.toString();
    }

    public static Boolean isIntegerZero (int number) {
        return  number == 0;
    }
}
