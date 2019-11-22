package com.documill.romantest;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author voletis
 *
 */
public class Utils {

	/**
	 * A local variable
	 */
	private LinkedHashMap<String, Integer> hm;
	private ArrayList<String> invalidKeys;

	/*
	 * Created a constructor 'Utils()' and loaded all default values so that they
	 * can be used during the code execution.
	 */

	public Utils() {

		/*
		 * A constructor is being to initialize a HashMap contains valid digits and an
		 * arrayList contains invalid sequence combinations.
		 * 
		 * Note: I could simply use some hard coded values using a case statement for the
		 * below literals but the reason why I have used a HashMap is, In a real world
		 * application this could be considered as a DB table's data that ensures the
		 * proper data structure to maintain.
		 */

		/* Add default Roman keys and corresponding decimal values */
		hm = new LinkedHashMap<>();
		hm.put("I", 1);
		hm.put("V", 5);
		hm.put("X", 10);
		hm.put("L", 50);
		hm.put("C", 100);
		hm.put("D", 500);
		hm.put("M", 1000);

		/*
		 * The below invalid key list ensures for incorrect entries.
		 */
		invalidKeys = new ArrayList<String>();

		/*
		 * The rule says, 'I', 'X', 'C' & 'M' can be repeated and is limited to only 3
		 * times. Any of these keys found repeated for more than 3 times will be
		 * rejected for conversion.
		 */
		invalidKeys.add("IIII");
		invalidKeys.add("XXXX");
		invalidKeys.add("CCCC");
		invalidKeys.add("MMMM");

		/*
		 * The rule says, 'V', 'L', & 'D' cannot be repeated. Any of these keys found
		 * repeated for more than 1 time will be rejected for conversion.
		 */
		invalidKeys.add("VV");
		invalidKeys.add("LL");
		invalidKeys.add("DD");

		/*
		 * Symbol 'I' can be subtracted from 'V' and 'X' only. i.e, 'I' can't be placed
		 * before other bigger digits
		 */
		invalidKeys.add("IL");
		invalidKeys.add("IC");
		invalidKeys.add("ID");
		invalidKeys.add("IM");

		/*
		 * Symbol 'X' can be subtracted from 'L' and 'C' only. i.e, 'I' can't be placed
		 * before other bigger digits
		 */
		invalidKeys.add("XD");
		invalidKeys.add("XM");

		/*
		 * Symbol 'C' can be subtracted from 'D' and 'M' only. So neednot add any
		 */

	} // End of constructor

	/*
	 * convertRomanNumerals method takes the input and validates
	 */
	public void convertRomanNumerals(String romanNumeralString) {

		/*
		 * Split the input string into an array of strings
		 */
		String[] strs = romanNumeralString.split("");

		/* 'tot' variable carries the total value of the converted input. */
		int tot = 0;

		/*
		 * Iterate over the array of strings
		 */
		for (int i = 0; i < strs.length; i++) {

			int num1 = hm.get(strs[i]);

			/* check if the next character exists */
			if ((i + 1) < strs.length) {

				int num2 = hm.get(strs[i + 1]);
				/*
				 * If first number is greater than the next number perform Addition else
				 * subtraction to be done from the second number.
				 */
				if (num1 >= num2) {
					tot = tot + num1;
				} else {
					tot = tot + num2 - num1;
					i++;
				}
			} else {
				tot = tot + num1;
			}

		}

		System.out.println("The converted decimal number is : '" + tot + "'");

	}

	/*
	 * isValidRomanNumeral method validates the user input
	 */
	public boolean isValidRomanNumeral(String romanNumeralString) {

		/*
		 * Return false if invalid characters exist
		 */
		String[] strs = romanNumeralString.split("");
		for (String str : strs) {
			if (!hm.containsKey(str)) {
				System.out.print("There is an invalid character found '" + str + "'. ");
				return false;
			}
		}

		/*
		 * Return false if invalid characters sequence exist
		 */
		for (String key : invalidKeys) {
			if (romanNumeralString.contains(key)) {
				System.out.print("There is an invalid sequence found '" + key + "'. ");
				return false;
			}
		}

		/* Reaching this line ensures that entered input is a Valid one to convert */
		return true;
	}
}
