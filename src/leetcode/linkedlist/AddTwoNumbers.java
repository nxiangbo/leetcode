package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

/**
 * ²Î¿¼ÍøÉÏ´úÂë
 * @author nxiangbo
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 ==null || l2 ==null){
        	return null;
        }
        ListNode prevNode = new ListNode(0);
        ListNode head = prevNode;
        int carry = 0;
        while(l1!=null || l2 != null || carry != 0 ){
        	ListNode currNode = new ListNode(0);
        	int sum = ((l1==null)?0:l1.data)+((l2==null)?0:l2.data)+carry;
        	currNode.data = sum%10;
        	carry = sum/10;
        	prevNode.next = currNode;
        	prevNode = currNode;
        	l1 = (l1==null)?l1:l1.next;
        	l2 = (l2==null)?l2:l2.next;
        }
        return head.next;
    }
}
