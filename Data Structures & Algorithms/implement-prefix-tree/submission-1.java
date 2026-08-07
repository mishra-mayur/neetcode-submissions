class PrefixTree {
    Node root;

    public PrefixTree() {
        this.root = new Node(null);
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.toCharArray().length; i++) {
            char c = word.charAt(i);
            if (curr.children.containsKey(c)) {
            } else {
                curr.children.put(c, new Node(c));
            }

            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
        // System.out.println(root);
    }

    public boolean search(String word) {
        Node node = searchUtil(word);
        return null != node && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchUtil(prefix) != null;
    }

    private Node searchUtil(String str) {
        Node curr = root;
        for (char c : str.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return null;
            }
        }
        return curr;
    }
}

class Node {
    boolean isEndOfWord;
    Character c;
    Map<Character, Node> children;

    public Node(Character c) {
        this.c = c;
        this.children = new HashMap();
    }

    public String toString() {
        return "\nNode { " + c + " end " + isEndOfWord + " children : " + children + "}\n";
    }
}
