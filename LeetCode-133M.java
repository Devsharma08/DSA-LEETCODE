/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> hash = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return node;

        if(hash.containsKey(node)){
            return hash.get(node);
        }

        Node cloneNode = new Node(node.val,new ArrayList<Node>());
        // adding it to hash
        hash.put(node,cloneNode);

        // hash.get(cloneNode).add()
        for(Node temp:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(temp));
        }


        return cloneNode;

    }
}