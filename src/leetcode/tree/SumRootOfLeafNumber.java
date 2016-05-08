package leetcode.tree;

import java.util.ArrayDeque;

public class SumRootOfLeafNumber {
	public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int result = 0;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left==null&&node.right==null){
                result += node.val;
            }
            
            if(node.right!=null){
                String strNode = String.valueOf(node.val);
                String strRight = String.valueOf(node.right.val);
                node.right.val = Integer.parseInt(strNode+strRight);
                stack.push(node.right);
                
            }
            
            if(node.left!=null){
                String strNode = String.valueOf(node.val);
                String strLeft = String.valueOf(node.left.val);
                node.left.val = Integer.parseInt(strNode+strLeft);
                stack.push(node.left);
            }
            
        }
        return result;
    }
}
