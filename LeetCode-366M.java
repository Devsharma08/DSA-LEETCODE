
class Solution{

    public int LeafNode(TreeNode root,List<List<Integer>> list){
        if root==null return 0 ;

        int leftH = LeafNode(root.left,list);
        int rightH = LeafNode(root.right,list);

        int currH = Math.max(leftH,rightH)+1;

        if(currH==list.size()){
            list.add(new ArrayList<>());
        }
        list.get(currH).add(root.val);
        return currH;
    }

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        LeafNode(root,list);
        return list;
    }
}