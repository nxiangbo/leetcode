package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
        
        List<Integer> res = new LinkedList<>();
        for(int i=0;i<(1<<n);i++){
            res.add(i^i>>1);
        }
        
        return res;
    }
}
