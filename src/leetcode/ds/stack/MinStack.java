package leetcode.ds.stack;

/**
 * 栈的操作
 * 需要注意的是，如何在O(1)时间内查找栈中的最小值
 * 本段程序是在Node节点中保存一个最小值的字段
 * @author nxiangbo
 *
 */
public class MinStack {
	class Node{
		int data;
		int min;
		Node next;
		public Node(int data, int min, Node next) {
			this.data = data;
			this.min = min;
			this.next = next;
		}
		
		public Node(int data, int min) {
			this(data,min, null);
		}
		
		public Node() {
			this(0,0, null);
		}
	}
	
	private Node top;
//	private Node minNode = new Node();
	
	public int top(){
		return (top!=null)?top.data:null;
	}
	
	public void push(int x){
		Node newNode;
		if(top == null){
			newNode = new Node(x, x);
			top = newNode;
		} else{
			newNode = new Node(x, Math.min(x, top.min));
			newNode.next = top;
			top = newNode;
		}
	}
	
	public int pop(){
		Node resultNode = new Node();
		if(top!=null){
			resultNode = top;
			top = top.next;
		}
		return resultNode.data;
	}
	
	public int getMin(){
		return top.min;
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(12);
		stack.push(32);
		stack.push(56);
//		stack.getMin();
		System.out.println(stack.getMin());
		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
	}
}
