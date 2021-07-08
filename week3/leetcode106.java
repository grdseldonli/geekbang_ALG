/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0) {
			 
			 return null;
		 }
		 TreeNode root=new TreeNode (postorder[postorder.length-1]);

         if(inorder.length==1){
            return root;
                     
         }
		 for(int  i=0; i<postorder.length;i++) {
			 
			 if(postorder[postorder.length-1]==inorder[i]) {
				 
                root.left=buildTree(Arrays.copyOfRange(inorder,0,i),
									Arrays.copyOfRange(postorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),
									 Arrays.copyOfRange(postorder,i,postorder.length-1));	

				 
			 }
	 
			 
		 }


		 return root;
    }
}
