package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        char[] strs = new char[2*n];
        for(int i=0;i<n;i++){
            strs[i] = ')';
        }
        for(int i=n;i<2*n;i++){
            strs[i] = '(';
        }
        
        for (char c : strs) {
			System.out.print(c);
		}
        List<String> res = new ArrayList<>();
        //ееап
        
        permutations(res,strs,0,strs.length);
        
//        for (String string : res) {
//			System.out.println(string);
//		}
        return res;
    }
    
    public void permutations(List<String> res, String permute, int start, char[] strs){
        if(permute.length()==strs.length){
            if(isParent(permute)){
                res.add(permute);
            }
            return;
        }
        
        for(int i=start;i<permute.length();i++){
            String newPermute = new String(permute);
            newPermute +=strs[start];
            System.out.println(newPermute);
            permutations(res,newPermute, start+1,strs);
        }
    }
    
    public boolean isParent(String str){
        char[] chars = str.toCharArray();
        Queue<Character> stack = new LinkedList<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.offer(chars[i]);
            } else if(!stack.isEmpty()&&chars[i]==')'&&stack.peek()=='('){
                stack.poll();
            } else{
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public void permutations(List<String> res, char[] chars, int first, int end){
    	if(first == end){
    		String permute = "";
    		for(int i=0;i<end;i++){
    			permute+=chars[i];
    		}
    		if(isParent(permute)){
    			res.add(permute);
    		}
//    		System.out.println(permute);
    		return;
    	}
    	
    	for(int i=first;i<end;i++){
    		swap(chars, i, first);
    		permutations(res,chars, first+1, end);
    		swap(chars, i, first);
    	}
    }
    
    private void swap(char[] chars, int i, int j){
    	char temp = chars[i];
    	chars[i] = chars[j];
    	chars[j] = temp;
    }
    
    public static void main(String[] args) {
		int n =3;
		GenerateParentheses g = new GenerateParentheses();
		g.generateParenthesis(n);
		
//		char[] chars = {'a','b','c'};
//		permutations(chars, 0, 3);
	}
}
