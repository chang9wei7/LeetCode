package com.note4j.RemoveDuplicate;

public class ListNode<T> {
	T val;
	ListNode<T> next;

	ListNode(T x) {
		val = x;
		next = null;
	}

	/**
	 * add new node with value in parameters.
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode<T> add(ListNode<T> head, T val) {
		ListNode<T> node = new ListNode<T>(val);
		ListNode<T> cur = head;
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

	/**
	 * insert new node before the index in parameters. 下标从1开始
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode<T> insert(ListNode<T> head, int index, T val) {
		ListNode<T> node = new ListNode<T>(val);
		ListNode<T> cur = head;
		if (head == null) {
			head = node;
			return head;
		}
		// index bigger than the length of the list.
		if (index > this.getLength(head)) {
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = node;
			return head;
		}

		int count = 0;
		while (cur != null) {
			count++;
			if (count == index) {
				node.next = cur.next;
				cur.next = node;
				node.val = cur.val;
				cur.val = val;
				return head;
			}
			cur = cur.next;
		}
		return head;
	}

	/**
	 * delete one node by value.If more than one node,only delete the first
	 * node.
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode<T> delByVal(ListNode<T> head, T val) {
		ListNode<T> pre, cur;
		if (head == null) {
			return head;
		}
		cur = head;
		pre = null;

		if (head.val == val) {
			if (head.next == null) {
				return null;
			}
			// 利用移位（值替换）来进行删除头结点
			if (head.next != null) {
				head.val = head.next.val;
				head.next = head.next.next;
				return head;
			}
		}

		pre = cur;
		cur = cur.next;

		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
				return head;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}

	/**
	 * delete one node by index.If index bigger than list length ,delete the
	 * last one node.
	 * 
	 * @param head
	 * @param index
	 * @return
	 */
	public ListNode<T> delByIndex(ListNode<T> head, int index) {
		ListNode<T> pre, cur;
		if (head == null) {
			return head;
		}
		cur = head;
		pre = null;
		int count = 0;
		if (head.next == null) {
			return null;
		}
		if (index >= this.getLength(head)) {
			while (cur.next != null) {
				pre = cur;
				cur = cur.next;
			}
			pre.next = cur.next;
		} else {
			if (index == 1 && cur.next != null) {
				cur.val = cur.next.val;
				cur.next = cur.next.next;
				return head;
			}
			while (cur.next != null) {
				count++;
				if (count == index) {
					pre.next = cur.next;
				} else {
					pre = cur;
					cur = cur.next;
				}

			}
		}

		return head;
	}

	/**
	 * get the length of the list.
	 * 
	 * @param head
	 * @return
	 */
	public int getLength(ListNode<T> head) {
		int count = 0;
		ListNode<T> cur = head;
		while (cur != null) {
			cur = cur.next;
			count++;
		}
		return count;
	}

	/**
	 * print the list.
	 * 
	 * @param head
	 */
	public void print(ListNode<T> head) {
		if (head == null) {
			return;
		} else {
			ListNode<T> cur = head;
			while (cur != null) {
				System.out.println(cur.val);
				cur = cur.next;
			}
		}
	}

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<Integer>(1);
		list.add(list, 2);
		list.add(list, 3);
		list.print(list);
		// list = list.delByIndex(list, 1);
		// new ListNode(1).print(list);
		// list = list.delByVal(list, 1);
		list.insert(list, 1, 20);
		list.print(list);

	}
}
