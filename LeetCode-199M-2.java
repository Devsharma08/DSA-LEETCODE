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

    public void LevelT(TreeNode temp,int level,List<Integer> result){
        if(temp==null) return ;

        if(result.size()==level){
            result.add(temp.val);
        }
        // starting from the right side first
        LevelT(temp.right,level+1,result);
        LevelT(temp.left,level+1,result);

    }
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) new ArrayList<Integer>();
        int level = 0 ;
        List<Integer> result = new ArrayList<>();
        LevelT(root,level,result);

        return result;
    }
}