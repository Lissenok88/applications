package com.foxminded.lyudmila.IntegerDivision;

import java.util.ArrayList;

public class IntegerDivision {

    public String integerDivisionColumn(int dividend, int divisor) {
        if (divisor == 0) {
            return "Cannot divide by zero";
        }
        ArrayList<Data> result = new ArrayList<>();
        Data data = new Data();
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        String[] dividendDigits = String.valueOf(dividend).split("");

        data.setParameter1(Integer.toString(dividend));
        data.setParameter2(Integer.toString(divisor));
        data.setMultiplier("0");
        data.setStep(0);
        result.add(data);

        if (dividend < divisor) {
            return formattingResult(result);
        }
        result.addAll(divisionColumn(dividendDigits, divisor));
        return formattingResult(result);
    }

    private ArrayList<Data> divisionColumn(String[] dividendDigits, int divisor) {
        ArrayList<Data> result = new ArrayList<>();
        int i = 0;
        int productNumber;
        int multiplier;
        int step = 0;
        String notFullDividend = dividendDigits[i++];

        while (i < dividendDigits.length) {
            Data data = new Data();
            data.setMultiplier("");
            int j = 0;
            while (Integer.parseInt(notFullDividend) < divisor) {
                if (Integer.parseInt(notFullDividend) == 0) {
                    notFullDividend = dividendDigits[i++];
                    if (j > 0) {
                        data.setMultiplier(data.getMultiplier() + "0");
                        step++;
                    }
                    j++;
                } else {
                    notFullDividend += dividendDigits[i++];
                }
            }
            multiplier = Integer.parseInt(notFullDividend) / divisor;
            productNumber = divisor * multiplier;

            data.setParameter1(notFullDividend);
            data.setParameter2(Integer.toString(productNumber));
            data.setMultiplier(data.getMultiplier() + multiplier);
            data.setStep(step);

            step += notFullDividend.length();
            notFullDividend = Integer.toString(Integer.parseInt(notFullDividend) - productNumber);
            if (Integer.parseInt(notFullDividend) != 0 && i <= dividendDigits.length) {
                step -= notFullDividend.length();
            }
            result.add(data);
        }

        if (Integer.parseInt(notFullDividend) == 0) {
            step -= notFullDividend.length();
        }

        Data data = new Data();
        data.setParameter1(notFullDividend);
        data.setParameter2("");
        data.setMultiplier("");
        data.setStep(step);
        result.add(data);
        return result;
    }


    public String formattingResult(ArrayList<Data> arrayData) {
        StringBuilder result = new StringBuilder();
        String multiplier = "";
        String spaces;
        String dash;

        if (arrayData.size() == 1) {
            result.append(arrayData.get(0).getParameter1() + "|" + arrayData.get(0).getParameter2() + "\n");
            spaces = countSpaces(arrayData.get(0).getParameter1().length());
            dash = countDash(arrayData.get(0).getParameter2().length());
            result.append(spaces + "|" + dash + "\n");
            result.append(spaces + "|" + arrayData.get(0).getMultiplier());
            return result.toString();
        }

        for (int i = 1; i < arrayData.size(); i++) {
            multiplier += arrayData.get(i).getMultiplier();
        }

        result.append("_" + arrayData.get(0).getParameter1() + "|" + arrayData.get(0).getParameter2() + "\n");
        spaces = countSpaces(arrayData.get(0).getParameter1().length() - arrayData.get(1).getParameter2().length());
        dash = countDash(multiplier.length());
        result.append(" " + arrayData.get(1).getParameter2() + spaces + "|" + dash + "\n");
        dash = countDash(arrayData.get(1).getParameter1().length());
        result.append(" " + dash + spaces + "|" + multiplier + "\n");

        arrayData.stream().skip(2).limit((arrayData.size() - 3)).map(q -> {
            StringBuilder string = new StringBuilder();
            int iterator;
            string.append(countSpaces(q.getStep()) + "_" + q.getParameter1() + "\n");
            iterator = q.getParameter1().length() - q.getParameter2().length();
            string.append(countSpaces(q.getStep() + iterator) + " " + q.getParameter2() + "\n");
            string.append(countSpaces(q.getStep() + 1) + countDash(q.getParameter1().length()) + "\n");
            return string;
        }).forEach(result :: append);

        result.append(countSpaces(arrayData.get(arrayData.size() - 1).getStep()) + " " +
                  arrayData.get(arrayData.size() - 1).getParameter1());
        return result.toString();
    }

    private String countSpaces(int iterator) {
        int i = 1;
        String spaces = "";
        while (i <= iterator) {
            spaces += " ";
            i++;
        }
        return spaces;
    }

    private String countDash(int iterator) {
        int i = 1;
        String dash = "";
        while (i <= iterator) {
            dash += "-";
            i++;
        }
        return dash;
    }

}
