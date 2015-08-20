package com.note4j.SameTree;

/**
 * @author changwei
 *
 */
public class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;

	}

	public static void preTraverse(TreeNode p) {
		if (p == null) {
			return;
		} else {
			System.out.println(p.val);
			preTraverse(p.left);
			preTraverse(p.right);
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		t1.right = new TreeNode(21);
		t1.left = new TreeNode(3);
		t1.right.left = new TreeNode(1);
		TreeNode t2 = new TreeNode(10);
		t2.right = new TreeNode(21);
		t2.left = new TreeNode(3);
		t2.right.left = new TreeNode(1);
		System.out.println(isSameTree(t1, t2));
	}
}
