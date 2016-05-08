package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import leetcode.linkedlist.LinkedList;

public class BinaryTree {
	private TreeNode root;

	public BinaryTree() {
	}

	public BinaryTree(TreeNode root) {
		this.root = root;
	}

	public void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + ", ");
			preOrder(node.left);
			preOrder(node.right);
		}

	}
	//先序遍历，非递归
	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if(root==null){
	            return result;
	        }
	        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
	        stack.push(root);
	        while(!stack.isEmpty()){
	            TreeNode node = stack.pop();
	            result.add(node.val);
	            if(node.right!=null){
	                stack.push(node.right);
	            }
	            if(node.left!=null){
	                stack.push(node.left);
	            }
	            
	        }
	        return result;
	    }

	public void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.val + ", ");
		}
	}

	public void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.val + ", ");
			inOrder(node.right);
		}
	}
	/**
	 * 中序非递归遍历
	 * @param root
	 * @return
	 */
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if(root==null){
	            return result;
	        }
	        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
	        TreeNode node = root;
	        do{
	            while(node!=null){
	                stack.push(node);
	                node = node.left;
	            }
	            if(!stack.isEmpty()){
	                node = stack.pop();
	                result.add(node.val);
	                node = node.right;
	            }
	        } while(node!=null||!stack.isEmpty());
	        return result;
	    }
	 /**
	  * 后序非递归遍历
	  * @param root
	  * @return
	  */
	 public List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        TreeNode lastVisitNode = null;
	        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
	        while(!stack.isEmpty() || root!=null){
	            if(root!=null){
	                stack.push(root);
	                root = root.left;
	            }else{
	                TreeNode peekNode = stack.peek();
	                if(peekNode.right!=null && lastVisitNode!=peekNode.right){
	                    root = peekNode.right;
	                } else{
	                    result.add(peekNode.val);
	                    lastVisitNode = stack.pop();
	                }
	            }
	        }
	        return result;
	    }
	public void buildTree(TreeNode root) {
		// root = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(4);
		root.left = left;
		root.right = right;
		TreeNode left2 = new TreeNode(5);
		TreeNode right2 = new TreeNode(6);
		root.left.left = left2;
		root.left.right = right2;
	}

	/**
	 * 树的最大深度
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
	}

	/**
	 * 是否是平衡二叉树
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		int diff = leftDepth - rightDepth;
		if (Math.abs(diff) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);
	}

	// public boolean isBalanced2(TreeNode root){
	// int depth = 0;
	// return isBalanced(root, depth);
	// }
	// private boolean isBalanced(TreeNode root2, int depth) {
	// if(root2==null){
	// depth = 0;
	// return true;
	// }
	// int left,right;
	// if(isBalanced(root2.left, left)&&isBalanced(root2.right,right))
	// return false;
	// }
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		return (leftDepth == 0 || rightDepth == 0) ? (leftDepth + rightDepth + 1)
				: Math.min(leftDepth + 1, rightDepth + 1);
	}

	/**
	 * 是否是相同的树
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

		return false;
	}

	/**
	 * 判断是否是对称树
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		TreeNode p = root.left;
		TreeNode q = root.right;

		return isSymmetric(p, q);
	}

	private boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val) {
			System.out.println(isSymmetric(p.left, q.right)
					&& isSymmetric(p.right, q.left));
			return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
		}

		return false;
	}

	public void buildSymmetricTree(TreeNode root) {
		// root = new TreeNode(2);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(4);
		root.left.left = left2;
		root.left.right = right2;
		TreeNode left3 = new TreeNode(3);
		TreeNode right3 = new TreeNode(4);
		root.right.left = right3;
		root.right.right = left3;
	}
	public void buildInvertTree(TreeNode root) {
		// root = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.right = right;
	}
	
	/**
	 * 反转树
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return root;
		}
		if(root.left==null&&root.right==null){
			return root;
		}
		TreeNode temp = new TreeNode(0);
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left!=null)
			invertTree(root.left);
		if(root.right!=null)
			invertTree(root.right);
		return root;
		
	}
	
	/**
	 * 按层遍历
	 * @param root
	 */
	public void levelOrder(TreeNode root) {
        if(root==null){
        	return ;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size()>0){
        	root = queue.get(0);
        	System.out.print(queue.get(0).val+", ");
        	queue.remove(0);
        	if(root.left!=null){
        		queue.add(root.left);
        	}
        	if(root.right!=null){
        		queue.add(root.right);
        	}
        }
        
    }
	
	public void levelOrder3(TreeNode root){
		if(root==null){
			return ;
		}
		Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.val+", ");
			if(node.left!=null){
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}
		}
	}
	
	/**
	 * Binary Tree Level Order Traversal in leetcode
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		 List<List<Integer>> results = new ArrayList<>();
	        if(root==null){
	        	return results;
	        }
	        
	        @SuppressWarnings("unchecked")
			Queue<TreeNode> queue = (Queue<TreeNode>) new LinkedList();
	        queue.offer(root);
	        while(queue.size()>0){
	        	int levelNum = queue.size();
	        	List<Integer> result = new ArrayList<Integer>();
	        	for (int i = 0; i < levelNum; i++) {
	        		if(queue.peek().left!=null){
	            		queue.offer(queue.peek().left);
	            	}
	            	if(queue.peek().right!=null){
	            		queue.offer(queue.peek().right);
	            	}
	            	result.add(queue.poll().val);
				}
	        	results.add(result);
	        }
	        return results;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		BinaryTree tree = new BinaryTree();
		tree.buildTree(root);
		tree.inOrder(root);
		System.out.println();
		System.out.println(tree.maxDepth(root));
		System.out.println(tree.isBalanced(root));
		System.out.println(tree.minDepth(root));
		TreeNode root2 = new TreeNode(0);
		BinaryTree tree2 = new BinaryTree();
		tree.buildTree(root2);
		System.out.println(isSameTree(root, root2));
		System.out.println("对称树");
		TreeNode root3 = new TreeNode(1);
		BinaryTree tree3 = new BinaryTree();
		tree3.buildSymmetricTree(root3);
		System.out.println(tree3.isSymmetric(root3));
		System.out.println();
		tree3.preOrder(root3);
		
		System.out.println("invertTree");
		TreeNode root4 = new TreeNode(1);
		BinaryTree tree4 = new BinaryTree();
		tree.buildInvertTree(root4);
		TreeNode node = tree.invertTree(root4);
		tree.inOrder(node);
		
		System.out.println("按层遍历");
		tree3.levelOrder3(root3);
		System.out.println();
		tree3.levelOrder(root3);
	}
}
