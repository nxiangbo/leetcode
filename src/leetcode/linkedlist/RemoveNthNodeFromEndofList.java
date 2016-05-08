package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start = new ListNode(0);
        ListNode fast = start;
        ListNode slow = start;
        slow.next = head;
        for(int i = 0;i<=n;i++){
            fast = fast.next;
        }
        
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;        
        return start.next;
        
        
        
    }
}
