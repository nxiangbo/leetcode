package leetcode.backtracking;

import java.util.PriorityQueue;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if(s==null || p==null){
            return false;
        }
        
        return matchCore(s,p,0,0);
    }
    
    public boolean matchCore(String s, String p, int i, int j){
        if(i==s.length() && j==p.length()){
            return true;
        }
        
        if(i!=s.length() && j==p.length()){
            return false;
        }
        
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            if((i<s.length()&&j<p.length()&&s.charAt(i)==p.charAt(j)) || (p.charAt(j)=='.'&&i<s.length())){
                return 
                           matchCore(s,p,i+1,j+2) //�Ƶ���һ��״̬
                        || matchCore(s,p,i,j+2)   //����x*
                        || matchCore(s,p,i+1,j);  //ͣ���ڵ�ǰ״̬
                        
            } else{
                return matchCore(s,p,i,j+2);
            }
            
        }
        
        if((i<s.length()&&j<p.length()&&s.charAt(i)==p.charAt(j)) || (p.charAt(j)=='.'&&i<s.length())){
            return matchCore(s,p,i+1,j+1);
        }
        
        return false;
    }
}
