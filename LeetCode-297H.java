/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


    // Encodes a tree to a single string.
    public static void makingString(TreeNode root,StringBuilder encodeStr){
        if(root==null){
            encodeStr.append("X,");
            return;
        } 
        encodeStr.append(root.val).append(',');
        makingString(root.left,encodeStr);
        makingString(root.right,encodeStr);
    }


    public String serialize(TreeNode root) {
    StringBuilder encodeStr = new StringBuilder("");
    makingString(root,encodeStr);
    return encodeStr.toString();
    }


    private int i = 0 ;

    public TreeNode fillingTree(Queue<String> queue){
        // if(queue.isEmpty()) return root;
        String temp = queue.poll();
        if(temp.equals("X")){
            return null;
            // return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(temp));
        root.left = fillingTree(queue);

        root.right = fillingTree(queue);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        Queue<String> queue = new LinkedList<>();
        List<String> list = Arrays.asList(data.split(","));
        queue.addAll(list);
        return fillingTree(queue);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));