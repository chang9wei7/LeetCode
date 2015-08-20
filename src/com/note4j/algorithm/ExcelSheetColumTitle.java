package com.note4j.algorithm;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author changwei
 *
 */
public class ExcelSheetColumTitle {
	public static String convertToTitle(int n) {
		if (n <= 26) {
			return String.valueOf((char) (n-1+'A'));
		} else {
			return convertToTitle((n-1) / 26) + (char) ((n-1) % 26  + 'A');
		}
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(78));
		// System.out.println((char) 65);
	}
}
