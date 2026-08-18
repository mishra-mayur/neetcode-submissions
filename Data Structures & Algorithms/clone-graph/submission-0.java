/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;

        Map<Node, Node> map = new HashMap();

        Node temp = node;
        populateMap(map, temp);
        temp = node;
        completeConnections(map, temp);
        return map.get(node);
    }

    private void populateMap(Map<Node, Node> map, Node node) {
        if(node == null)
            return;

        if(map.containsKey(node))
            return;
        
        map.put(node, new Node(node.val));

        for (Node temp : node.neighbors) {
            populateMap(map, temp);
        }
    }

    private void completeConnections(Map<Node, Node> map, Node node) {
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            List<Node> list = new ArrayList<>();
            for (Node n : entry.getKey().neighbors) {
                list.add(map.get(n));
            }
            entry.getValue().neighbors = list;
        }
    }
}