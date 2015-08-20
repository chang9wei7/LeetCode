package com.note4j.algorithm;

/**
 * 
 * @author changwei
 * 
 *         Find the contiguous subarray within an array (containing at least one
 *         number) which has the largest product.
 * 
 *         For example, given the array [2,3,-2,4], the contiguous subarray
 *         [2,3] has the largest product = 6.
 * 
 */

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		int max = A[0];
		int min = A[0];
		int result = A[0];
		if (A.length == 1) {
			return A[0];
		}
		for (int i = 1; i != A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(A[i] * max, min * A[i]), A[i]);
			min = Math.min(Math.min(A[i] * temp, min * A[i]), A[i]);
			result = Math.max(max, result);
		}
		return result;
	}

	public static void main(String[] args) {
		int A[] = { -4, -3, -2,-2};
		System.out.println(new MaximumProductSubarray().maxProduct(A));
	}
}
