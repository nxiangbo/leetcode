package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<>();
	        for(int i=0;i<nums.length-3;i++){
	            if(i>0&&nums[i]==nums[i-1]) continue;
	            for(int j=i+1;j<nums.length-2;j++){
	                if(j>i+1&&nums[j]==nums[j-1]) continue;
	                int low = j+1;
	                int high = nums.length-1;
	                while(low<high){
	                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
	                    if(sum==target){
	                        System.out.println(nums[i]);
	                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
	                        while(low<high&&nums[low]==nums[low+1]) low++;
	                        while(low<high&&nums[high]==nums[high-1]) high--;
	                        low++;
	                        high--;
	                    } 
	                    else if(sum<target){
	                        low++;
	                    } else{
	                        high--;
	                    }
	                }
	            }
	        }
	        
	        for (List<Integer> list : res) {
				System.out.println(list.toString());
			}
	        return res;
	    }
	 
	 public static List<List<Integer>> fourSum2(int[] num, int target) {
	        ArrayList<List<Integer>> ans = new ArrayList<>();
	        if(num.length<4)return ans;
	        Arrays.sort(num);
	        for(int i=0; i<num.length-3; i++){
	            if(i>0&&num[i]==num[i-1])continue;
	            for(int j=i+1; j<num.length-2; j++){
	                if(j>i+1&&num[j]==num[j-1])continue;
	                int low=j+1, high=num.length-1;
	                while(low<high){
	                    int sum=num[i]+num[j]+num[low]+num[high];
	                    if(sum==target){
	                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
	                        while(low<high&&num[low]==num[low+1])low++;
	                        while(low<high&&num[high]==num[high-1])high--;
	                        low++;
	                        high--;
	                    }
	                    else if(sum<target)low++;
	                    else high--;
	                }
	            }
	        }
	        
	        for (List<Integer> list : ans) {
				System.out.println(list.toString());
			}
	        return ans;
	    }
	    public static void main(String[] args) {
			int[] nums = {1,0,-1,0,-2,2};
			int target = 0;
			
			fourSum(nums, target);
	    }
}
