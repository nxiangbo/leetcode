package leetcode.heap;

public class HeapSort {
	public static void heapSort(int[] nums){
		MinHeap<Integer> pq = new MinHeap<>();
		for (int i = 0; i < nums.length; i++) {
			pq.offer(nums[i]);
		}
		int index = 0;
		while(!pq.isEmpty()){
			nums[index] = pq.poll();
			index++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {12,23,54,2,3,54,76,22};
		heapSort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
