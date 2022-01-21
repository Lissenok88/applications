package com.foxminded.lyudmila.anagram;

public class Anagrams {

	public String reversesLettersInWords(String string) {
		String[] splitText = string.split(" ");
		for (int i = 0; i < splitText.length; i++) {
			splitText[i] = reversesAllLetters(new StringBuilder(splitText[i]));
		}
		return String.join(" ", splitText);

	}

	private String reversesAllLetters(StringBuilder word) {
		int start = 0;
		int end = word.length() - 1;
		while (start < end) {
			while (!Character.isLetter(word.charAt(start)) && start < end) {
				start += 1;
			}
			while (!Character.isLetter(word.charAt(end)) && start < end) {
				end -= 1;
			}
			final char letter = word.charAt(start);
			word.setCharAt(start, word.charAt(end));
			word.setCharAt(end, letter);
			start += 1;
			end -= 1;

		}
		return word.toString();
	}
}
