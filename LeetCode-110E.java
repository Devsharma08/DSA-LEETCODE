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
    // public static int maximum = 0 ;
    public int checkHeight(TreeNode temp){
        if(temp==null) return 0;
        int heightLeft = checkHeight(temp.left);
        int heightRight = checkHeight(temp.right);

        return Math.max(heightLeft,heightRight)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        // checking height of nodes
        int num = checkHeight(root.left);
        int num2 = checkHeight(root.right);

        // checking if current node balanced
        if(Math.abs(num-num2)> 1){
            return false;
        } 
        // check if child node balanced
        return isBalanced(root.left) && isBalanced(root.right); 
}
}