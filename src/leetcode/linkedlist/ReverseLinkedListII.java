package leetcode.linkedlist;

import leetcode.linkedlist.LinkedList.ListNode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null){
            return head;
        }
         java.util.LinkedList<ListNode> stack = new java.util.LinkedList<>();
         ListNode pre = null;
         ListNode nex = null;
         int count = 0;
         //找到第m和n个位置,并将m...n的值入栈
         for(ListNode x = head; x!=null;x=x.next){
             count++;
             if(count==m-1){
                 pre = x;
             }
             
             if(count==n+1){
                 nex = x;
             }
             
             if(count>=m&count<=n){
                 stack.push(x);
             }
         }
         
         //反转m...n的链表
         ListNode newHead = stack.pop();
         ListNode current = newHead;
         current.next = null;
         while(!stack.isEmpty()){
             ListNode next = stack.pop();
             next.next = null;
             current.next = next;
             current = next;
         }
         
        //找到反转后链表的最后一个结点
         ListNode temp = newHead; 
         ListNode lastNode = null;
         while(temp!=null){
             if(temp.next==null){
                 lastNode = temp;
                 break;
             }
             temp = temp.next;
         }
         
         if(pre==null){
             lastNode.next = nex;
             return newHead;
         }
         if(nex!=null){
             lastNode.next = nex;
         }
         pre.next = newHead;  
         return head;
         
    }
}
