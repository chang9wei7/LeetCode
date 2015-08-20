package com.note4j.RemoveDuplicate;

import java.util.Scanner;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author changwei
 *
 */
public class RemoveDupicaties2 {
	public static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<Integer> pre, cur, next;
		cur = head;
		next = cur.next;
		pre = null;
		boolean flag = false;
		while (next != null) {
			if (cur.val == next.val) {
				flag = true;
				cur.next = next.next;
				next = next.next;
			} else {
				flag = false;
				pre = cur;
				cur = next;
				next = next.next;
			}

			if (flag == true && next == null && pre == null) {
				return null;
			} else if (flag == true && next == null && pre != null) {
				pre.next = null;
			} else if (flag == true && cur.val != next.val) {
				cur.val = next.val;
				cur.next = next.next;
				next = cur.next;
			}
		}

		return head;
	}

	/**
	 * 增加节点
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode<Integer> addNode(ListNode<Integer> head, int val) {
		ListNode<Integer> node = new ListNode<Integer>(val);
		ListNode<Integer> cur = head;
		if (head == null) {
			head = node;
			return head;
		}

		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
		return head;
	}

	public static void main(String[] args) {
		ListNode<Integer> head = null;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int temp = sc.nextInt();
			if (temp == 999)
				break;
			if (head == null) {
				head = new ListNode<Integer>(temp);
			} else {
				addNode(head, temp);
			}

		}
		sc.close();
		ListNode<Integer> cur = head;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
		head = deleteDuplicates(head);
		cur = head;
		System.out.println("************************");
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}
