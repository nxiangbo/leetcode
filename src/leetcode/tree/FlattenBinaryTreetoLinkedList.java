package leetcode.tree;

public class FlattenBinaryTreetoLinkedList {
	 public void flatten(TreeNode root) {
	        helper(root,null);
	    }
	    
	    public TreeNode helper(TreeNode node, TreeNode prev){
	        if(node==null) return prev;
	         prev = helper(node.right, prev);
	         prev = helper(node.left, prev);
	         node.right = prev;
	         node.left = null;
	         prev = node;
	         return prev;
	    }
}
