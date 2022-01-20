package com.foxminded.lyudmila.task1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Boolean indicator = true;

		while (indicator) {
			System.out.println("\nAnnagram program.");
			System.out.println(
					"Enter your text or select test text:\n " + "1 - Enter text \n" + " 2 - Test \n " + "0 - exit\n");
			String chosenNumber = new Scanner(System.in).nextLine();

			if (Verification.isNumber(chosenNumber)) {
				int chosenIndex = Integer.parseInt(chosenNumber);
				switch (chosenIndex) {
				case 1:
					System.out.println("\nEnter your text: ");
					System.out.println("\nResult: " + Anagrams.anagramText(new Scanner(System.in).nextLine()));
					break;
				case 2:
					String testText = "abcd1j absd!jh";
					System.out.println("\nTest text: " + testText);
					System.out.println("\nResult: " + Anagrams.anagramText("abcd1j absd!jh"));
					break;
				case 0:
					indicator = false;
					break;
				default:
					System.out.println("\nEnter incorrect symbol.");
					break;
				}
			} else {
				System.out.println("Enter incorrect symbol.");
			}
		}

	}

}
