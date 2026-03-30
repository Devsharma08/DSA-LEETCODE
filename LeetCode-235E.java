/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // assume p value to be smallest every time
        int pVal = p.val;
        int qVal = q.val;
        if(pVal>qVal){
            return lowestCommonAncestor(root, q, p);
        }
        int currVal = root.val;
        // if any match found at root
        if(currVal==pVal || currVal == qVal){
            return root;
        } 

        // if currval is lies b/w p and q return that node
        if(currVal > pVal && currVal < qVal ){
            return root;
        } 
        if(currVal > pVal && currVal > qVal){
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);
    }
}