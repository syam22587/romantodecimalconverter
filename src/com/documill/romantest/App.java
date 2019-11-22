package com.documill.romantest;

import java.util.Scanner;

/**
 * @author voletis
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Utils is an extra utility class where all necessary functions were
		 * implemented and used.
		 */
		Utils utils = new Utils();

		/* Initialize an empty variable to store the input */
		String romanNumeralString = "";

		/* Initialize a scanner to receive inputs */
		Scanner scanner = new Scanner(System.in);

		/*
		 * 'do while' loop is used to test the functionality repeatedly without re
		 * running the application. Variable 'c' is used to store the User's input
		 * choice ('Y' or 'N')
		 */
		String c = "";

		do {

			System.out.print("Please enter a ROMAN numeral to convert (I to M i.e, 1 to 1000)  :  ");
			romanNumeralString = scanner.next().toUpperCase();

			System.out.println(String.format("You have entered '%s'  ", romanNumeralString));

			/*
			 * First check if the entered input is Valid. If the input is invalid then break
			 * it before it checks else retrieve the output by calling
			 * convertRomanNumerals() method.
			 */

			if (utils.isValidRomanNumeral(romanNumeralString)) {
				utils.convertRomanNumerals(romanNumeralString);
			} else {
				System.out.println("The Roman numeral you have entered is invalid :( ");
			}

			System.out.println("Do you want to test the feature with a new input again ? (Y or N)");
			c = scanner.next();

			System.out.println("----------------------------------------"
					+ "--------------------------------------------------------");

		} while (c.equalsIgnoreCase("Y"));

		/* Close the scanner */
		scanner.close();

		System.out.println("\nYou have selected a 'N' option or entered an invalid option. "
				+ "Thank you for using of our Roman numeral converter Service. Good Bye :)  ");
	}

}
