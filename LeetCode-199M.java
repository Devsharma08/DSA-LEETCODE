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

    public void LevelT(TreeNode temp,int level,HashMap result){
        if(temp==null) return ;


        if(!result.containsKey(level)){
            result.put(level,temp.val);
        }


        // starting from the right side first
        LevelT(temp.right,level+1,result);
        LevelT(temp.left,level+1,result);

    }
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) new ArrayList<Integer>();
        int level = 0 ;
        
        HashMap<Integer,Integer> list = new HashMap<>();
        LevelT(root,level,list);

        List<Integer> result = new ArrayList<>();
    
        // int level = 0;
        while (list.containsKey(level)) {
            result.add(list.get(level));
            level++;
        }

        return result;
    }
}