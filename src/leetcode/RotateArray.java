package leetcode;
/**
 * 向右循环移动数组。刚开始，用最笨的方法，逐次移动，会有超时。
 * 更好的方法：
 * 以[1,2,3,4,5,6,7] k=3
 * [1,2,3,4] [5,6,7]
 * (1) [4,3,2,1] [7,6,5]
 * (2) [4,3,2,1,7,6,5] ==> [5,6,7,1,2,3,4]
 * 即得正解
 * @author nxiangbo
 *
 */
public class RotateArray {
	public static void rotate(int[] nums, int k) {
		
		int r = k%nums.length;
		if(r<=nums.length/2){
			//向右移动r
			for (int j = 0; j < r; j++) {
				int temp = nums[nums.length-1];
				for (int i = nums.length-1; i > 0; i--) {
					nums[i] = nums[i-1];
				}
				nums[0] = temp;
				
			}
		} else{
			//向左移动nums.length-r
			for (int j = 0; j < nums.length-r; j++) {
				int temp = nums[0];
				for (int i = 0; i < nums.length-1; i++) {
					nums[i] = nums[i+1];
				}
				nums[nums.length-1] = temp;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}
	
	public static void rotate2(int[] nums, int k) {
		k = k%nums.length;
		System.out.println("k="+k);
		reverse(nums, 0, nums.length-k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"  ");
		}
		System.out.println();
		reverse(nums, nums.length-k, nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"  ");
		}
		System.out.println();
		reverse(nums, 0, nums.length);
//		System.out.println();
//		for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i]+"  ");
//		}
//		System.out.println();
	}
	
	public static void reverse(int[] nums, int l, int r){
		while(l<r){
			int temp = nums[l];
			nums[l++] = nums[--r];
			nums[r] = temp;
//			l++;
//			r--;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
//		reverse(nums, 0, 3);
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
		int k = 6;
		rotate2(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
