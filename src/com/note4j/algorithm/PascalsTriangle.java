package com.note4j.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author changwei
 *
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if(numRows == 0){
			return listOfList;
		}
		list.add(1);
		listOfList.add(list);
		
		if (numRows == 1) {
			return listOfList;
		}

		for (int i = 1; i != numRows; i++) {
			if (i == 1) {
				list = new ArrayList<Integer>();
				list.add(1);
				list.add(1);
				listOfList.add(list);
				continue;
			}
			list = new ArrayList<Integer>();
			List<Integer> tempList = listOfList.get(i - 1);
			for (int j = 0; j != tempList.size(); j++) {
				if (j == 0) {
					list.add(tempList.get(j));
				} else {
					list.add(tempList.get(j - 1) + tempList.get(j));
				}
			}
			list.add(1);
			listOfList.add(list);
		}
		return listOfList;
	}

	public static void main(String[] args) {
		System.out.println(new PascalsTriangle().generate(0));
	}
}
