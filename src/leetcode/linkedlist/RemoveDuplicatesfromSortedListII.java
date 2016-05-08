package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode pre = dumpy;
        ListNode current = head;
        
        while(current!=null){
            while(current.next!=null&&current.data==current.next.data){
                current = current.next;
            }
            
            if(pre.next==current){
                pre = current;
                
            } else{
                pre.next = current.next;
            }
            current = current.next;
        }
        return dumpy.next;
    }
}
