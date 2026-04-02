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

    int i = 0 ;

    // declaring hashmap
    Map<Integer,Integer> hash = new HashMap<>();

    public TreeNode BST(int start , int end,int[] preorder){
        if(end < start) return null ;
        int val = preorder[i];
        TreeNode temp  = new TreeNode(preorder[i++]);
        
        int mid = hash.get(val) ;
        temp.left = BST( start , mid-1,preorder ) ;
        temp.right = BST( mid+1 , end,preorder ) ;
        return temp;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // declaring vars 
        int end = preorder.length;
        int start = 0 ;

        // seed value into hash with value as key
        for(int j = 0; j < end ;j++){
            hash.put(inorder[j],j);
        }
        TreeNode root = new TreeNode(0);
        // if (end==0) return TreeNode(0);

        return BST( start , end-1,preorder);

        
    }
}