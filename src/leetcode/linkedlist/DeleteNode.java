package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class DeleteNode {
	public void deleteNode(ListNode node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFromHead(1);
		list.addFromTail(2);
		list.addFromTail(3);
		list.addFromTail(4);
		list.addFromTail(5);
		list.addFromTail(1);
		list.addFromTail(2);
		list.addFromTail(1);
		list.print();
		
		
	}
}
