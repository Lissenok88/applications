package com.foxminded.lyudmila.integer.division;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input dividend:");
            int dividend = scanner.nextInt();
            System.out.println("Input divisor:");
            int divisor = scanner.nextInt();
            System.out.println(new IntegerDivision().integerDivisionColumn(dividend, divisor));
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect enter.");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
