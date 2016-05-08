package leetcode.ds.stack;

public class MyQueue {
	private MyStack stack1 = new MyStack();
	private MyStack stack2 = new MyStack();
	
	public void push(int x){
		stack1.push(x);
	}
	
	public int pop(){
		if(!stack2.empty()){
			return stack2.pop();
		} 
		while(!stack1.empty()){
			stack2.push(stack1.pop());
			
		}
		return stack2.pop();
		
	}
	
	public int peek(){
		if(!stack2.empty()){
			return stack2.peek();
		} 
		while(!stack1.empty()){
			stack2.push(stack1.pop());
			
		}
		return stack2.peek();
	}
	
	public boolean empty(){
		return stack1.empty()&&stack2.empty();
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(12);
		queue.push(13);
		queue.push(14);
		System.out.println(queue.pop());
	}
}
