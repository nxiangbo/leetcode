package leetcode.tree;

import java.util.ArrayDeque;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				node.right.val = node.right.val + node.val;
				stack.push(node.right);

			}
			if (node.left != null) {
				node.left.val = node.left.val + node.val;
				stack.push(node.left);
			}

			if (node.left == null && node.right == null) {
				if (node.val == sum) {
					return true;
				}
			}

		}

		return false;
	}
	
	public boolean hasPathSumWithRecursive(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        
        if(root.left==null&&root.right==null&&sum-root.val==0) return true;
        
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
    }
}
