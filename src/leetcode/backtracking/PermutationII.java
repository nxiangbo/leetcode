package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationII {
	 public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
	        // write your code here
	        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	        helper(res, new ArrayList<Integer>(), nums, 0);
	        for (ArrayList<Integer> arrayList : res) {
				System.out.println(arrayList.toString());
			}
	        return res;
	    }
	    
	    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> permute, ArrayList<Integer> nums, int start){
	        if(permute.size()==nums.size()){
	            ArrayList<Integer> temp = new ArrayList<Integer>(permute);
	            if(!res.contains(temp)){
	            	res.add(temp);
	            }
	            
                return;
	        }
	        
	        for(int i=0;i<=permute.size();i++){
	            ArrayList<Integer> newPermute = new ArrayList<>(permute);
	            System.out.println(i+","+start);
	            newPermute.add(i, nums.get(start));
	            helper(res, newPermute, nums, start+1);
	        }
	    }
	    
	    public static void main(String[] args) {
			PermutationII p = new PermutationII();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			nums.addAll(Arrays.asList(new Integer[]{1,2,2}));
			p.permuteUnique(nums);
		}
}
