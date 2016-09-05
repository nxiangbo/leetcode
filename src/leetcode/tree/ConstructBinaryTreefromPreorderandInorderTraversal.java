package leetcode.tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<=0 || inorder.length<=0 || preorder.length!=inorder.length){
            return null;
        }
        
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int i, int low, int high){
        if(i>=preorder.length || low>high) return null;
        
        TreeNode node = new TreeNode(preorder[i]);
        int mid = 0;
        for(int j=low;j<=high;j++){
            if(preorder[i]==inorder[j]){
                mid = j;
            }
            
        }
        node.left = helper(preorder,inorder,i+1,low,mid-1);
        node.right = helper(preorder,inorder,i-low+mid+1,mid+1,high);
        
        
        return node;
    }
}
