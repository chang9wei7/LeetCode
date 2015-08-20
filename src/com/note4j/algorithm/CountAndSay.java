package com.note4j.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * @author changwei
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			return "";
		} else if (n == 1) {
			return Integer.toString(1);
		}

		list.add(1);

		for (int i = 2; i <= n; i++) {
			int count = 1;
			List<Integer> tempList = new ArrayList<Integer>();
			for (int j = 0; j != list.size() - 1; j++) {
				if (list.get(j) == list.get(j + 1)) {
					count++;
				} else {
					tempList.add(count);
					tempList.add(list.get(j));
					count = 1;
				}
			}
			// 计算未完成的循环
			tempList.add(count);
			tempList.add(list.get(list.size() - 1));
			list = tempList;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i != list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(8));
	}
}
