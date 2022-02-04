package com.foxminded.lyudmila.integer.division;

public class Verification {
    public static Boolean isIntegerNumber(String string) {
        if (string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect enter.");
            return false;
        }
    }
}
