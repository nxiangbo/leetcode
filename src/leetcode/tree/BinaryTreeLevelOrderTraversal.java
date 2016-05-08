package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        @SuppressWarnings("unchecked")
		Queue<TreeNode> queue = (Queue<TreeNode>) new LinkedList();
        LinkedList<List<Integer>> stack = new LinkedList<>();
        if(root==null){
            return results;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i<len;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                result.add(queue.poll().val);
            }
            
            stack.push(result);
        }
        
        while(!stack.isEmpty()){
            results.add(stack.pop());
        }
        return results;
    }
}
