package com.note4j.RemoveDuplicate;

import java.util.Scanner;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author changwei
 *
 */
public class RemoveDuplicates1 {
	public static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<Integer> cur, next;
		cur = head;
		next = cur.next;

		while (next != null) {
			if (cur.val == next.val) {
				cur.next = next.next;
				next = next.next;
			} else {
				cur = next;
				next = next.next;
			}
		}
		return head;
	}

	/**
	 * 链表的逆置操作
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode<Integer> reverse(ListNode<Integer> head) {
		ListNode<Integer> pre, cur, next;
		if (head == null || head.next == null) {
			return head;
		}

		pre = next = null;
		cur = head;

		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		head = pre;

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
		head = reverse(head);
		// deleteDuplicates(head);
		cur = head;
		System.out.println("************************");
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}
