package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        String[] mapping = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits==null || digits.length()<=0){
            return res;
        }
        res.add("");
        for(int i=0;i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length()==i){
                String t = res.remove();
                for(char c:mapping[x].toCharArray()){
                    res.add(t+c);
                }
            }
        }
        return res;
    }
}
