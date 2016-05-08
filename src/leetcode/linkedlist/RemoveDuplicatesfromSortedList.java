package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode previousNode = head;
        ListNode current = head.next;
        while(current!=null){
            if(previousNode.data==current.data){
                previousNode.next = current.next;
                current = previousNode.next;
            } else{
                previousNode = current;
                current = current.next;
            }
        }
        return head;
    }
}
