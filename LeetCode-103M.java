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
    public void LinearT(TreeNode temp,int level,List<List<Integer>> result){
        if(temp==null){
            return ;
        }

        if(level==result.size()){
            result.add(new ArrayList<Integer>());
        }
        if(level%2==0) result.get(level).add(temp.val);
        else result.get(level).add(0,temp.val);
            LinearT(temp.left,level+1,result);
            LinearT(temp.right,level+1,result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // if(root==null) return null;
        List<List<Integer>> list = new ArrayList<>();

        int level = 0 ;
        LinearT(root,level,list);
        return list;
    }
}