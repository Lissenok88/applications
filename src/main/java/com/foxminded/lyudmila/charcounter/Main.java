package com.foxminded.lyudmila.charcounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashingCharCounter cash = new CashingCharCounter(new CharCounter());
        System.out.println("Enter string:");
        String string = scanner.nextLine();
        System.out.println(cash.getUniqueChars(string));
        System.out.println();
        System.out.println(cash.getUniqueChars(string));
        scanner.close();
    }
}
