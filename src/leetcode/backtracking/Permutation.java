package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums.length <= 0)
			return results;

		permutation(nums, 0, new ArrayList<Integer>(), results);

		return results;

	}

	public static void permutation(int[] nums, int start,
			List<Integer> permutation, List<List<Integer>> permutations) {
		if (permutation.size() == nums.length) {
			permutations.add(permutation);
			System.out.println(permutation.toString());
			return;
		}

		for (int i = 0; i <= permutation.size(); i++) {
			List<Integer> newPermutation = new ArrayList<>(permutation);
			newPermutation.add(i, nums[start]);

			permutation(nums, start + 1, newPermutation, permutations);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		permute(nums);
	}
	
}
