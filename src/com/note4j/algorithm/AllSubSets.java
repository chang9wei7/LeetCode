package com.note4j.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author changwei
 *
 */
public class AllSubSets {
	public static List<List<Integer>> subsets(int[] S) {
		// 异常条件判断
		if (S == null || S.length == 0) {
			return null;
		}

		Arrays.sort(S);

		List<List<Integer>> listOfList = new ArrayList<>();
		listOfList.add(new ArrayList<Integer>());

		for (int i : S) {
			List<List<Integer>> temp = new ArrayList<>();
			for (List<Integer> tempList : listOfList) {
				List<Integer> list = new ArrayList<Integer>(tempList);
				list.add(i);
				temp.add(list);
			}
			listOfList.addAll(temp);
		}

		return listOfList;

	}

	public static void main(String[] args) {
		// int[] i = { 1, 3, 5, 7 };
		// System.out.println(subsets(i).toString());
		List<Integer> list = new LinkedList<Integer>();
		list.add(20);
		list.add(10);
		List<Integer> list2 = new ArrayList<Integer>(list);
		System.out.println(list2.toString());
	}
}
