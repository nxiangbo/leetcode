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
	
	/**
	 * ƽ����˵�������зֵ�ѡ���㷨������ʱ�������Լ����
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
