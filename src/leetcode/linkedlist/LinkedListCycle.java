package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow.equals(fast)) {
				return true;
			}

		}
		return false;

	}

	public ListNode detectCycle(ListNode head) {
		boolean isCycle = false;
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				isCycle = true;
				break;
			}
		}
		if (!isCycle) {
			return null;
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
