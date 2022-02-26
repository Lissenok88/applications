package com.foxminded.lyudmila.formula1;

import java.time.format.DateTimeParseException;

public class Main {
    private static final String ABBREVIATIONS_FILE = "/abbreviations.txt";
    private static final String START_MOMENTS_FILE = "/start.log";
    private static final String FINISH_MOMENTS_FILE = "/end.log";


    public static void main(String[] args) {
        try {
            System.out.println(new Formula1().formula1(START_MOMENTS_FILE, FINISH_MOMENTS_FILE, ABBREVIATIONS_FILE));
        } catch (NullPointerException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (DateTimeParseException ex) {
            System.out.println("Input wrong data time format.");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Input incorrect racer data format.");
        }
    }
}
