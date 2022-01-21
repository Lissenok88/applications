package com.foxminded.lyudmila.anagram;

import java.util.Scanner;

public class Main {
	public static final String ENTER = "enter";
	public static final String TEST = "test";
	public static final String EXIT = "exit";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		loop: while (true) {
			System.out.println("\nAnnagram program.\n");
			System.out.println("Enter your string or select test:");
			System.out.println("1. Enter \n" + "2. Test \n" + "3. Exit\n");
			String action = scanner.nextLine().toLowerCase();

			switch (action) {
			case ENTER:
				System.out.println("\nEnter string: ");
				System.out.println("\nResult: " + new Anagrams().reversesLettersInWords(scanner.nextLine()));
				break;
			case TEST:
				String testText = "abcd1j absd!jh";
				System.out.println("\nTest: " + testText);
				System.out.println("\nResult: " + new Anagrams().reversesLettersInWords("abcd1j absd!jh"));
				break;
			case EXIT:
				break loop;
			default:
				System.out.println("\nIncorrect enter.");
				break;
			}
		}
		scanner.close();
	}

}
