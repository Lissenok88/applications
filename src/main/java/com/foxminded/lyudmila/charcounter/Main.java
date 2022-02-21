package com.foxminded.lyudmila.charcounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashingCharCounter charCounter = new CashingCharCounter(new CharCounter());
        System.out.println("Enter string:");
        String input = scanner.nextLine();
        System.out.println(charCounter.getUniqueChars(input));
        System.out.println();
        System.out.println(charCounter.getUniqueChars(input));
        scanner.close();
    }
}
