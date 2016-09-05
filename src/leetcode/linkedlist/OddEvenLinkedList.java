package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class OddEvenLinkedList {
	public static ListNode oddEvenList(ListNode head) {
        ListNode p = head;
        ListNode even = new ListNode(0);
        ListNode q = even;
        while(p.next!=null&&p.next.next!=null){
            ListNode temp = p.next;
            q.next = temp;
            q = q.next;
            p.next = p.next.next;
            p = p.next;
            System.out.println(p.data);
        }
        
        p.next = even.next;
        return head;
    }
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode node = new ListNode(1);
		list.addHead(node);
		list.addFromTail(2);
		list.addFromTail(3);
		list.addFromTail(4);
		list.addFromTail(5);
		list.addFromTail(6);
		list.addFromTail(7);
		list.addFromTail(8);
		
		list.print();
		
		ListNode head = oddEvenList(node);
		list.print(head);
		
		
	}
}
