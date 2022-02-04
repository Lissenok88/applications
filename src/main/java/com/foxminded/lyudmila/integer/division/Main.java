package com.foxminded.lyudmila.integer.division;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input dividend:");
        String number1 = scanner.nextLine();
        System.out.println("Input divisor");
        String number2 = scanner.nextLine();

        if (Verification.isIntegerNumber(number1) && Verification.isIntegerNumber(number2)) {
            int dividend = Integer.parseInt(number1);
            int divisor = Integer.parseInt(number2);
            String result = new IntegerDivision().integerDivisionColumn(dividend, divisor);
            System.out.println(result);
        }
        scanner.close();
    }
}
