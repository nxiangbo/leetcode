package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class IntersectionofTwoLinkedLists {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int lenA = 0;
	        int lenB = 0;
	        for(ListNode x = headA;x!=null;x=x.next){
	            lenA++;
	        }
	        
	        for(ListNode y = headB;y!=null;y=y.next){
	            lenB++;
	        }
	        
	        ListNode NodeA = headA;
	        ListNode NodeB = headB;
	        int len = 0;
	        if(lenA>lenB){
	            for(int i=0;i<lenA-lenB;i++){
	                NodeA = NodeA.next;
	            }
	            len = lenB;
	        } else{
	            for(int i=0;i<lenB-lenA;i++){
	                NodeB = NodeB.next;
	            }
	            len = lenA;
	        }
	        
	        for(int j = 0;j<len;j++){
	            if(NodeA==NodeB){
	                return NodeA;
	            }
	            NodeA = NodeA.next;
	            NodeB = NodeB.next;
	        }
	        return null;
	    }
}
