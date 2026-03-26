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

    public void Level(TreeNode temp,int level,List<List<Integer>> result){
        if(temp==null) return;
        List<Integer> t1 = new ArrayList<>();
        if(level==result.size()){
            result.add(t1);
        }
        result.get(level).add(temp.val);     
        Level(temp.left,level+1,result);
        Level(temp.right,level+1,result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        
        if(root==null) return list;
        int level = 0 ;
        Level( root,level,list);   
        return list;
    }
}