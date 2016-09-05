package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        helper(res,new ArrayList<Integer>(),root,0,sum);
        
        return res;
        
    }
    
    public void helper(List<List<Integer>> res, List<Integer> path, TreeNode node, int pathSum, int sum){
        path.add(node.val);
        pathSum+=node.val;
        if(node.left==null && node.right==null){
            if(pathSum==sum){
                // System.out.println(pathSum);
                res.add(new ArrayList<>(path));
            }
        }
        
        if(node.left!=null){
            helper(res,path,node.left,pathSum,sum);
        }
        
        if(node.right!=null){
            helper(res,path,node.right,pathSum,sum);
        }
        path.remove(path.size()-1);
    }
}
