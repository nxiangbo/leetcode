package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class MergeTwoSortedLists {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null&&l2==null){
	            return null;
	        }
	        if(l1==null){
	            return l2;
	        }
	        if(l2==null){
	            return l1;
	        }
	        
	        ListNode head = new ListNode(Integer.MIN_VALUE);
	        ListNode current = head;
	        while(l1!=null && l2!=null){
	            if(l1.data<l2.data){
	                current.next = l1;
	                l1 = l1.next;
	            } else{
	                current.next = l2;
	                l2 = l2.next;
	            }
	            current = current.next;

	        }
	        
	        current.next = (l1==null)?l2:l1;
	        return head.next;
	    }
}
