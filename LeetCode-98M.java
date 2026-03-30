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
    public boolean Binary(TreeNode root,long min,long max){
        if(root==null) return true;
        // checking next roots
        if(min >= root.val || max <= root.val)  return false;

        return Binary(root.left,min,root.val) && Binary(root.right,root.val,max);

    }

    public boolean isValidBST(TreeNode root) {
        return Binary(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}