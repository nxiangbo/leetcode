package leetcode;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (j - i <= k && Math.abs(nums[i] - nums[j]) <= t) {
					System.out.println("i=" + i + "  j=" + j + " nums[i]="
							+ nums[i] + " nums[j]=" + nums[j]);
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if(nums==null||nums.length<=0||k<0){
			return false;
		}
		
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0;i<nums.length;i++){
			Integer floor = set.floor(nums[i]+t);
			Integer ceil = set.ceiling(nums[i]-t);
			
			if((floor!=null&&floor>=nums[i])||(ceil!=null&&ceil<=nums[i])){
				return true;
			}
			
			set.add(nums[i]);
			if(i>=k){
				set.remove(nums[i-k]);
			}
		}
		
		for (Integer integer : set) {
			System.out.println(integer);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 54, 32, 4 };
		int k = 2;
		int t = 0;
		System.out.println(containsNearbyAlmostDuplicate2(nums, k, t));
	}
}
