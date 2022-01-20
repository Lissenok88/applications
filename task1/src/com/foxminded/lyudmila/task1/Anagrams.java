package com.foxminded.lyudmila.task1;

public class Anagrams {

	public static String anagramText(String text) {
		String anagramString = "";
		String[] splitText = text.split(" ");
		for (String word : splitText) {
			anagramString += anagramWord(word) + " ";
		}
		return anagramString;
	}

	public static String anagramWord(String word) {
		StringBuilder anagram = new StringBuilder("");
		String reverseWordOfSymbols = new StringBuffer(searchSymbols(word)).reverse().toString();
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

	public static String searchSymbols(String word) {
		StringBuilder wordOfSymbols = new StringBuilder("");
		for (int indexWord = 0; indexWord < word.length(); indexWord++) {
			if (Character.isLetter(word.charAt(indexWord)))
				wordOfSymbols.append(word.charAt(indexWord));
		}
		return wordOfSymbols.toString();
	}
}
