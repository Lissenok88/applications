package com.foxminded.lyudmila.anagram;

import java.util.ArrayList;

public class Anagrams {

	public String reversesLetterInWords(String string) {
		String[] splitText = string.split(" ");
		ArrayList<String> arrayAnagramWord = new ArrayList<>();
		for (String word : splitText) {
			arrayAnagramWord.add(reversesAllLetter(new StringBuilder(word)));
		}
		return String.join(" ", arrayAnagramWord);
	}

	private String reversesAllLetter(StringBuilder word) {
		int indexStart = 0;
		int indexEnd = word.length() - 1;
		while (indexStart < indexEnd) {
			if (Character.isLetter(word.charAt(indexStart)) 
					&& Character.isLetter(word.charAt(indexEnd))) {
				char ch = word.charAt(indexStart);
				word.setCharAt(indexStart, word.charAt(indexEnd));
				word.setCharAt(indexEnd, ch);
				indexStart++;
				indexEnd--;
			} else if (!Character.isLetter(word.charAt(indexStart))) {
				indexStart++;
			} else if (!Character.isLetter(word.charAt(indexEnd))) {
				indexEnd--;
			} else {
				indexStart++;
				indexEnd--;
			}

		}
		return word.toString();
	}
}
