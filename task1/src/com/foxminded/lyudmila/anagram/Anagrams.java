package com.foxminded.lyudmila.anagram;

import java.util.ArrayList;

public class Anagrams {

	public String reversesLetterInWordsOfString(String string) {
		String[] splitText = string.split(" ");
		ArrayList<String> arrayAnagramWord = new ArrayList<>();
		for (String word : splitText) {
			arrayAnagramWord.add(reversesLetterInWord(word));
		}
		return String.join(" ", arrayAnagramWord);
	}

	public String reversesLetterInWord(String word) {
		StringBuilder anagram = new StringBuilder();
		String reverseWordOfSymbols = new StringBuilder(searchAllLetterInWord(word)).reverse().toString();
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

	public String searchAllLetterInWord(String word) {
		StringBuilder wordOfSymbols = new StringBuilder();
		for (int indexWord = 0; indexWord < word.length(); indexWord++) {
			if (Character.isLetter(word.charAt(indexWord))) {
				wordOfSymbols.append(word.charAt(indexWord));
			}
		}
		return wordOfSymbols.toString();
	}
}
