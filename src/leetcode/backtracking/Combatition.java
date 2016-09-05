package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combatition {
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        Set<String> set = new HashSet<>(Arrays.asList(new String[]{"we","we"}));
        for (String string : set) {
			System.out.println(string);
		}
        return combs;
    }
	
	
	
	
	public static void combine(List<List<Integer>> results, List<Integer> comb, int start, int n, int k){
		if(k==0){
			results.add(new ArrayList<Integer>(comb));
			return;
		}
		
		for(int i=start;i<=n;i++){
			comb.add(i);
			combine(results, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
    public static void main(String[] args) {
		combine(5, 3);
	}
    
}
