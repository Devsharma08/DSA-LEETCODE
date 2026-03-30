class Solution {

    public boolean isEqual(TreeNode root,TreeNode subRoot){
        if(root==null || subRoot==null){
            if(root==null && subRoot==null) return true;
            return false;
        }
        if(root.val!=subRoot.val) return false;
        return isEqual(root.left,subRoot.left) && isEqual(root.right,subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;

        if(root.val==subRoot.val && isEqual(root,subRoot)){
            return true;
        } 
        
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}