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
    public int ifGood(TreeNode curr,int max){
        if(curr==null) return 0;
        int count = 0;
        if(curr.val >= max) {
            count=1;
            max = curr.val;
        }
        
        count+=ifGood(curr.left,max);
        count+=ifGood(curr.right,max);
        return count;
    }

    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        int count = ifGood(root,root.val);
        return count;
    }
}