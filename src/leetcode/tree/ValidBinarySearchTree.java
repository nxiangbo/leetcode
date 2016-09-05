package leetcode.tree;

public class ValidBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean helper(TreeNode node, long leftVal, long rightVal) {
		if (node == null) {
			return true;
		}
		if (node.val <= leftVal || node.val >= rightVal) {
			return false;
		}
		return helper(node.left, leftVal, node.val)
				&& helper(node.right, node.val, rightVal);
	}
}
