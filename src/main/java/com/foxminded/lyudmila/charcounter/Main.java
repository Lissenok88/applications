package com.foxminded.lyudmila.charcounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string:");
        String string = scanner.nextLine();
        System.out.println(new CharCounter().calculateUniqueChars(string));

        System.out.println("Enter string: " + string);
        System.out.println(new CashingCharCounter().getUniqueChars(string));

        scanner.close();
    }
}
