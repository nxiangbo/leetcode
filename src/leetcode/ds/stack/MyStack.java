package leetcode.ds.stack;

public class MyStack {
	class Node{
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}
	private Node top;
	
	public void push(int x){
		Node newNode = new Node(x);
		if(top==null){
			top = newNode;
		} else{
			newNode.next = top;
			top = newNode;
		}
		
	}
	
	public int pop(){
		Node peekNode = top;
		top = top.next;
		return peekNode.val;
	}
	
	public int peek(){
		return top.val;
	}
	
	public boolean empty(){
		return top==null;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(23);
		stack.push(13);
		stack.push(33);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}
}
