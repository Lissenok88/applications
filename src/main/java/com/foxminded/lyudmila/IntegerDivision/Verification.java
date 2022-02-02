package com.foxminded.lyudmila.IntegerDivision;

public class Verification {
    public static String checkingStringOnIntNumber(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        String minus = "";
        string = string.trim();

        if(string.indexOf("-") == 0) {
            minus = "-";
            string = string.substring(1);
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return "";
            }
        }

        int i = 0;
        while (i < string.length()) {
            if(string.charAt(i) != '0') {
                string = minus + string.substring(i);
                break;
            }
            i++;
        }

        if(string.length() != 0 && Long.parseLong(string) >= -2147483648 && Long.parseLong(string) <= 2147483647) {
            return string;
        } else {
            return "";
        }
    }
}
