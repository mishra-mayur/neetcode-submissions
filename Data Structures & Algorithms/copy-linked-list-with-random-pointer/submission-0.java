/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node temp = head;
        Map<Node, Node> map = new HashMap();

        while(temp != null) {
            Node node = new Node(temp.val);
            map.put(temp,node);
            temp = temp.next;
        }

        for(Map.Entry<Node, Node> entry : map.entrySet()) {
            entry.getValue().next = map.get(entry.getKey().next);
            entry.getValue().random = map.get(entry.getKey().random);
        }

        return map.get(head);
    }
}
