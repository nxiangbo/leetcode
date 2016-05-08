package leetcode.linkedlist;

import java.util.LinkedList;

import leetcode.linkedlist.LinkedList.ListNode;
/**
 * 反转链表
 * @author nxiangbo
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
	
	/**
	 * 递归解法
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    LinkedList<Integer> stack = new LinkedList<>();
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
}
