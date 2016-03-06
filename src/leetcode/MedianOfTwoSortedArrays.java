package leetcode;

public class MedianOfTwoSortedArrays {
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 double result = 0;
		 
		 if(nums1.length<=0&&nums2.length<=0){
			 return 0;
		 }
		 if(nums1.length<=0&&nums2.length>=1){
			 if(nums2.length%2==0){
				 return (double)(nums2[nums2.length/2]+nums2[(nums2.length/2)-1])/2;
			 }else{
				 return nums2[nums2.length/2];
			 }
			 
		 }
		 if(nums2.length<=0&&nums1.length>=1){
			 if(nums1.length%2==0){
//				 System.out.println(nums1[nums1.length/2-1]);
//				 System.out.println(nums1[nums1.length/2]);
////				 int tmp = nums1[nums1.length/2-1]
				 return (double)(nums1[nums1.length/2]+nums1[(nums1.length/2)-1])/2;
			 } else{
				 return nums1[nums1.length/2];
			 }
			 
		 }
		int n = (nums1.length+nums2.length)/2;
		int length = nums1.length+nums2.length;
		int i=0,j=0;
		double temp = 0;
		for (int k = 0; k <= n; k++) {
			
			if(i<nums1.length&&j<nums2.length){
				if(nums1[i]<nums2[j]){
					result = nums1[i];
					i++;
				} else{
					result = nums2[j];
					j++;
				}
			}else if(i<nums1.length&&j>=nums2.length){
				result = nums1[i];
				i++;
			} else if(j<nums2.length && i >= nums1.length){
				result = nums2[j];
				j++;
			}
			if(length%2==0){
				if(k==n-1){
					temp = result;
//					System.out.println("temp = "+temp);
				}
				if(k==n){
					System.out.println("result = "+result);
					
//					result = temp +result;
					result = (temp+result)/2;
//					System.out.println(temp+"  "+result);
				}
			}
			
		}
		return result;
	}
	 public static void main(String[] args) {
		int[] nums1 = {1,2,3};
		int[] nums2 = {1,2};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
