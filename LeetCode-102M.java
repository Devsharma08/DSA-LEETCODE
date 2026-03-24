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


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        // declare a queue
        Queue<TreeNode> q = new LinkedList<>();

        if(root==null) return list;
        // adding root to the queue
        q.offer(root);
        
        while(!q.isEmpty()){

            List<Integer> l = new ArrayList<>(); 

            int qSize = q.size();

            for(int i = 0 ; i < qSize ;i++ ){
                TreeNode temp = q.poll();
                l.add(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            list.add(l);
            // j++;
        }
        return list;
        
    }
}