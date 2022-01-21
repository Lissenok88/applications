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
		StringBuilder anagram = new StringBuilder();
		StringBuilder reverseWordOfSymbols = searchAllLetterInWord(word).reverse();
		int indexSymbols = 0;
		for (int indexWord = 0; indexWord < word.length(); indexWord++) {
			if (Character.isLetter(word.charAt(indexWord))) {
				anagram.append(reverseWordOfSymbols.charAt(indexSymbols));
				indexSymbols++;
			} else {
				anagram.append(word.charAt(indexWord));
			}
		}
		return anagram.toString();
	}

	private StringBuilder searchAllLetterInWord(StringBuilder word) {
		StringBuilder wordOfSymbols = new StringBuilder();
		for (int indexWord = 0; indexWord < word.length(); indexWord++) {
			if (Character.isLetter(word.charAt(indexWord))) {
				wordOfSymbols.append(word.charAt(indexWord));
			}
		}
		return wordOfSymbols;
	}
}
