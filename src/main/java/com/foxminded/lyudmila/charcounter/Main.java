package com.foxminded.lyudmila.charcounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string:");
        String string = scanner.nextLine();
        System.out.println(new CharCounter().calculateUniqueChars(string));

        CashingCharCounter cash = new CashingCharCounter();
        System.out.println("Enter string: " + string);
        System.out.println(cash.getUniqueChars(string));
        System.out.println("Enter string: " + string);
        System.out.println(cash.getUniqueChars(string));
        scanner.close();
    }
}
