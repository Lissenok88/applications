package com.foxminded.lyudmila.IntegerDivision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input dividend:");
        String number1 = Verification.checkingStringOnIntNumber(scanner.nextLine());

        System.out.println("Input divisor");
        String number2 = Verification.checkingStringOnIntNumber(scanner.nextLine());

        String result = "";
        if(number1 != null &&!number1.equals("") && number2 != null && !number2.equals("")) {
            int dividend = Integer.parseInt(number1);
            int divisor  = Integer.parseInt(number2);
            result = new IntegerDivision().integerDivisionColumn(dividend, divisor);
        } else {
            result = "Incorrect enter";
        }
        System.out.println(result);
        scanner.close();
    }
}
