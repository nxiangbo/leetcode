package leetcode.linkedlist;

public class LinkedList {
	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}

		public ListNode(int data) {
			this(data, null);
		}
	}

	private static ListNode head;
	private ListNode tail;

	public boolean isEmpty() {
		return head == null;
	}

	public void addHead(int item) {
		head = new ListNode(item);
		if (tail == null) {
			tail = head;
		}
	}

	public void addTail(int item) {
		if (!isEmpty()) {
			tail.next = new ListNode(item);
			tail = tail.next;
		} else {
			head = tail = new ListNode(item);
		}
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("null");
		} else {
			for (ListNode p = head; p != null; p = p.next) {
				System.out.print(p.data + ", ");
			}
			System.out.println();
		}
	}

	public void addFromHead(int item) {
		ListNode newListNode = new ListNode(item);
		newListNode.next = head;
		head = newListNode;
	}

	public void addFromTail(int item) {
		ListNode newListNode = new ListNode(item);
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
		}

		p.next = newListNode;
		newListNode.next = null;
	}

	public void insert(int item, int pos) throws Exception {
		
		ListNode prevListNode = locate(pos);
		ListNode newListNode = new ListNode(item);
		newListNode.next = prevListNode.next;
		prevListNode.next = newListNode;
		
	}

	public  ListNode locate(int pos) throws Exception {
		ListNode p = head;
		int length = 0;
		if (pos >= size()||pos<0) {
			throw new Exception("²ÎÊý´íÎó");
		}
		
		while (p != null) {
			if (pos == length) {
//				System.out.println(p.data);;
				break;
			}
			p = p.next;
			length++;
		}
		return p;
	}

	public int size() {
		int length = 0;
		for(ListNode p = head; p!=null;p = p.next){
			length++;
		}
		return length;
	}
	
	public int get(int pos) throws Exception{
		return locate(pos).data;
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		if(head==null){
            return null;
        }
        ListNode x = head;
        while(x.next!=null){
            if(x.next.data==val){
                x.next = x.next.next;
            } else{
                x = x.next;
            }
            
        }
        
        return (head.data==val)?head.next:head;
	}
	
	
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
//        while
    }
	
	public static void main(String[] args) throws Exception {
//		LinkedList list = new LinkedList();
//		LinkedList list2 = new LinkedList();
//		list.addHead(2);
//		list.addFromTail(3);
//		list.addFromTail(9);
//		list2.addHead(3);
//		list2.addFromTail(4);
//		list2.addFromTail(5);
//		
//		list.print();
//		int length = list.size();
//		int length2 = list2.size();
////		System.out.println(length);
//		for(int i = 0;i<3;i++){
//			ListNode result = list.addTwoNumbers(list.locate(i), list2.locate(i));
//			System.out.println("result = "+result.data);
//		}
//		
//		ListNode preListNode = list.locate(0);
//		System.out.println(preListNode.data);
//		list.insert(23, 2);
//		list.print();
		
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
		
		ListNode head2 = removeElements(head, 1);
		for (ListNode x = head2; x!=null; x=x.next) {
			System.out.print(x.data+", ");
		}
	}
}
