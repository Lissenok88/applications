package com.foxminded.lyudmila.integer.division;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input dividend:");
            int dividend = scanner.nextInt();
            System.out.println("Input divisor:");
            int divisor = scanner.nextInt();
            System.out.println(new IntegerDivision().integerDivisionColumn(dividend, divisor));
        } catch (Exception ex) {
            System.out.println("Incorrect enter.");
        } finally {
            scanner.close();
        }
    }
}
