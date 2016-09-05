package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
	 public List<String> binaryTreePaths(TreeNode root) {
	        
	        List<String> res = new ArrayList<>();
	        if(root==null) return res;
	        helper(res,root,"");
	        return res;
	    }
	    
	    public void helper(List<String> res, TreeNode node,String path){
	        path = path+node.val+"->";
	        if(node.left==null &&node.right ==null){
	            String temp = path.substring(0,path.length()-2);
	            res.add(temp);
	            return;
	        }
	        
	        if(node.left!=null){
	            helper(res, node.left, path);
	        }
	        
	        if(node.right!=null){
	            helper(res,node.right,path);
	        }
	    }
}
