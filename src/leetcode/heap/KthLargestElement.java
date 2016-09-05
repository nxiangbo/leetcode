package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 求解数组中第k大的数。
 * 这儿提供两种方法
 * 1.先排序，找出第k大的数。时间复杂度为O(NlogN);
 * 2.维护一个大小为k的最小堆,遍历一遍数组,完成后，最小堆的堆顶上的数据就是结果。时间复杂度为（O(N*logK)）
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
	 * 使用优先级队列（最小堆），维护一个大小为k的最小堆。时间复杂度为O(NlogK),空间复杂度O(k)
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
	
	/**
	 * 平均来说，基于切分的选择算法的运行时间是线性级别的
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargestWithSelect(int[] nums, int k) {
        if(nums.length<=0) return -1;
        shuffle(nums);
        int low = 0;
        int high = nums.length-1;
        k = nums.length-k;
        while(low<high){
            int j = partition2(nums, low, high);
            if(j==k) return nums[j];
            else if(j>k) high = j-1;
            else if(j<k) low = j+1;
        }
        return nums[k];
    }
    
    public int partition2(int[] nums, int low, int high){
        int i = low;
        int j = high+1;
        int pivot = nums[low];
        while(true){
            while(i<high&&nums[++i]<pivot) ;
            while(j>low&&nums[--j]>pivot) ;
            if(i>=j) break;
            swap(nums,i, j);
            
        }
        swap(nums, low, j);
        return j;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int r = i+rand.nextInt(n-i);
            int temp = nums[i];
            nums[i] = nums[r];
            nums[r] = temp;
        }
    }
	public static void main(String[] args) throws Exception {
		int[] nums = {1};
		int result = findKthLargest(nums,1);
		System.out.println(result);
	}
	
	
}
