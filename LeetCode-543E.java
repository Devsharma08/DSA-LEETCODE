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
    int height = 0 ;
    public int parse(TreeNode curr){
        if(curr==null) return 0;
       int lefth = parse(curr.left);
       int righth = parse(curr.right);

        height = Math.max(lefth+righth,height);

       return Math.max(lefth,righth)+1;
        
    }
   
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return 0;
        parse(root);
        return height;
    }
}