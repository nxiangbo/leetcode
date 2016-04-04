package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * ��������е�k�������
 * ����ṩ���ַ���
 * 1.�������ҳ���k�������ʱ�临�Ӷ�ΪO(NlogN);
 * 2.ά��һ����СΪk����С��,����һ������,��ɺ���С�ѵĶѶ��ϵ����ݾ��ǽ����ʱ�临�Ӷ�Ϊ��O(N*logK)��
 * @author nxiangbo
 *
 */
public class KthLargestElement {
	public static int findKthLargest(int[] nums, int k) {
		if(k<=0 || k>nums.length){
			return -1;
		}
		if(nums.length<=0){
			return -1;
		}
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }
	
	public static void quickSort(int data[], int low, int high){
		if(low<high){
			int mid = partition(data, low, high);
			quickSort(data, low, mid-1);
			quickSort(data, mid+1, high);
		}
	}

	private static int partition(int[] data, int low, int high) {
		int pivot = data[low];
		while(low<high){
			while(low<high && pivot <= data[high]){
				high--;
			}
			data[low] = data[high];
			while(low<high && pivot >= data[low]){
				low++;
			}
			data[high] = data[low];
		}
		data[low] = pivot;
		return low;
	}
	
	/**
	 * ʹ�����ȼ����У���С�ѣ���ά��һ����СΪk����С�ѡ�ʱ�临�Ӷ�ΪO(NlogK),�ռ临�Ӷ�O(k)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargestWithHeap(int nums[], int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : nums) {
			pq.offer(i);
			if(pq.size()>k){
				pq.poll();
			}
		}
		return pq.peek();
	}
	
//	public static int findKthLargestWithSelectAlgorithm(int nums[], int k){
//		int low = 0;
//		
//	}
//	
//	public int shuffle(int data[]){
//		Random random = new Random();
//		for
//	}
	public static void main(String[] args) throws Exception {
		int[] nums = {1};
		int result = findKthLargest(nums,1);
		System.out.println(result);
	}
	
	
}
