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
    // int max = 0 ;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0 ;
        // right side of the tree
        int rightVal = maxDepth(root.right);
        // left side of a tree
        int leftVal = maxDepth(root.left);
        // return max height 
        return Math.max(rightVal,leftVal) + 1;
    }
}