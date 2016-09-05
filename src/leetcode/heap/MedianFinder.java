package leetcode.heap;

import java.util.Arrays;
import java.util.Random;

public class MedianFinder {
	private int[] data ;
	private int size =0;;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;
	public MedianFinder() {
		this(12);
	}
	
	public MedianFinder(int initCapcity){
		data = new int[initCapcity];
	}
	
	 // Adds a number into the data structure.
    public void addNum(int num) {
    	ensureCapacity(size+1);
        data[size++] = num;
    }

    // Returns the median of current data stream
    public double findMedian() {
    	double median = 0.0;
        if(size%2==0){
        	int k = size/2;
        	median = (findKthLargestWithSelect(data, k)+findKthLargestWithSelect(data, k+1))/2.0;
        } else{
        	int k = size/2+1;
        	median = findKthLargestWithSelect(data, k);
        }
        return median;
    }
    
    private void ensureCapacity(int minCapacity){
    	if(minCapacity-data.length>0){
    		grow(minCapacity);
    	}
    }

	private void grow(int minCapacity) {
		int oldCapacity = data.length;
		int newCapacity = oldCapacity+(oldCapacity>>>1);
		if(newCapacity-minCapacity<0){
			newCapacity = minCapacity;
		}
		if(newCapacity-MAX_ARRAY_SIZE>0){
			newCapacity = MAX_ARRAY_SIZE;
		}
		data = Arrays.copyOf(data, newCapacity);
	}
	
	public int findKthLargestWithSelect(int[] nums, int k) {
        if(nums.length<=0) return -1;
        shuffle(nums);
        int low = 0;
        int high = nums.length-1;
        k = nums.length-k;
        while(low<high){
            int j = partition(nums, low, high);
            if(j==k) return nums[j];
            else if(j>k) high = j-1;
            else if(j<k) low = j+1;
        }
        return nums[k];
    }
    
    public int partition(int[] nums, int low, int high){
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
    
    public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		mf.addNum(5);
		System.out.println(mf.findMedian());
	}
}
