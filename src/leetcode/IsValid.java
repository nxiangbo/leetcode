package leetcode;

import java.util.LinkedList;

public class IsValid {
	public static boolean isValid(String s) {
		 if(s==null) return true;
	        LinkedList<Character> stack = new LinkedList<>();
	        
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
	                stack.push(s.charAt(i));
	            } else if(s.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=='('){
	                stack.pop();
	            } else if(s.charAt(i)==']'&&!stack.isEmpty()&&stack.peek()=='['){
	                stack.pop();
	            } else if(s.charAt(i)=='}'&&!stack.isEmpty()&&stack.peek()=='{'){
	                stack.pop();
	            } else{
	                return false;
	            }
	            
	            
	        }
//	        System.out.println(stack.size());
	        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String str = "()[]({})";
		System.out.println(isValid(str));
	}
}
