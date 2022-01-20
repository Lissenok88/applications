package com.foxminded.lyudmila.task1;

public class Verification {
	
	public static boolean isNumber(String string) {
		if (string == null || string.isEmpty())
			return false;
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i)))
				return false;
		}
		return true;
	}
}
