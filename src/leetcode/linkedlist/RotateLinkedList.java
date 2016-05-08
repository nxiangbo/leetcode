package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class RotateLinkedList {
	 public ListNode rotateRight(ListNode head, int k) {
	        if(head==null||head.next==null){
	            return head;
	        }
	        int len = 0;
	        for(ListNode x = head;x!=null;x=x.next){
	            len++;
	        }
	        
	        int split = len-(k%len);
	        ListNode leftNode = head;
	        for(int i=1;i<split;i++){
	            leftNode = leftNode.next;
	        }
	        ListNode rightNode = leftNode.next;
	        leftNode.next = null;
	        // System.out.println(leftNode.val);
	        ListNode left = reverse(head);
	        ListNode right = reverse(rightNode);
	        ListNode result = null;
	        for(ListNode x = left;x!=null;x=x.next){
	            if(x.next==null){
	                x.next = right;
	                result = reverse(left);
	                break;
	            }
	        }
	        return result;

	    }
	    
	    public ListNode reverse(ListNode head){
	        if(head==null || head.next==null){
	            return head;
	        }
	        
	        ListNode next = null;
	        ListNode pre = null;
	        while(head!=null){
	            next = head.next;
	            head.next = pre;
	            pre = head;
	            head = next;
	        }
	        return pre;
	    }
}
