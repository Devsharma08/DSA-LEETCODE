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
    public boolean isEqual(TreeNode left,TreeNode right){
        if(left==null || right==null){
            if(left==null && right==null) return true;
            return false;
        }
       
        return left.val==right.val && isEqual(left.left,right.right) && isEqual(left.right,right.left);
        // else return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isEqual(root.left,root.right);

    }
}