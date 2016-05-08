package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

import leetcode.linkedlist.LinkedList.ListNode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<Integer>();
        for(ListNode x = head; x!=null;x=x.next){
            nums.add(x.data);
        }
        int low = 0;
        int high = nums.size()-1;
        while(low<high){
            if(!nums.get(low).equals(nums.get(high))){
                // System.out.println(nums.get(low)+" ,"+nums.get(high));
                return false;
            }
            low++;
            high--;
        }
        
        return true;
    }
}
