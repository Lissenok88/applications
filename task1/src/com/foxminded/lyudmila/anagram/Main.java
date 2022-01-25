package com.foxminded.lyudmila.anagram;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string:");
        String string = scanner.nextLine();
        System.out.println("\nResult: ");
        System.out.println(new Anagrams().reversesLettersInWords(string));
        scanner.close();
    }
}
