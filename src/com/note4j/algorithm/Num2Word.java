package com.note4j.algorithm;

/**
 * 
 * @author changwei
 *
 */
public class Num2Word {
	public static String convertToTitle(int n) throws Exception {
		int count = 0;
		int index = 0;
		// if(n > 0){
		count = n / 26 + 1;
		index = n % 26;
		getIndex(index, count);
		// }else{
		// throw new Exception("Please Input a positive number!");
		// }
		return null;
	}

	public static void getIndex(int index, int count) {
		char c = (char) ((int) 'A' + index - 1);
		String str = "";
		for (int i = 0; i != count; i++) {
			str += c;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		// char a = 'A';
		// System.out.println((int)a);
		try {
			convertToTitle(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}