package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<>();
        helper(res,new ArrayList<String>(),s,0);
        return res;
    }
    
    public void helper(List<String> result, List<String> ip, String s, int start){
        if(ip.size()==4){
            if(start!=s.length())  return;
            
            StringBuilder sb = new StringBuilder();
            for(String partIP:ip){
                sb.append(partIP);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
        }
        
        for(int i=start;i<s.length()&&i<=start+3;i++){
            String temp = s.substring(start,i+1);
            if(isValid(temp)){
                ip.add(temp);
                helper(result,ip,s,i+1);
                ip.remove(ip.size()-1);
            }
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0)=='0'){
            return s.equals("0");
        }
        
        int val = Integer.valueOf(s);
        
        return val>=0&&val<=255;
    }
}
