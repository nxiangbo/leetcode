package leetcode.tree;

public class ConstructBinaryTreefromPostorderandInorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<=0 || postorder.length<=0) return null;
        
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(postStart>postEnd) return null;
        int pos = 0;
        for(int i=inStart;i<=inEnd;i++){
            // System.out.println("i="+i+" "+"postEnd"+postEnd);
            if(inorder[i]==postorder[postEnd]){
                
                pos = i;
                break;
            }
        }
        TreeNode node = new TreeNode(inorder[pos]);
        node.left = helper(inorder, postorder, inStart, pos-1, postStart, postStart+pos-inStart-1);
        node.right = helper(inorder, postorder, pos+1, inEnd, postEnd-(inEnd-pos), postEnd-1);
        
        return node;
    }
}
