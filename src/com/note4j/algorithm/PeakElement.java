package com.note4j.algorithm;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * @author changwei
 *
 */
public class PeakElement {

	public static int findPeakElement(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		// 保存peak数的位置
		int index = 0;
		int peak = num[0];
		for (int i = 1; i != num.length; i++) {
			if (num[i] > peak) {
				peak = num[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 1, 2, 3, 4 };
		System.out.println(findPeakElement(a));
	}
}
