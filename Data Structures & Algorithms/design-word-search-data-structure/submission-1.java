class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node(null);
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children.containsKey(word.charAt(i))) {
                //
            } else {
                curr.children.put(word.charAt(i), new Node(word.charAt(i)));
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        return searchUtil(curr, word, 0);
    }

    private boolean searchUtil(Node curr, String word, int index) {
        if (index == word.length())
            return curr.isEndOfWord;

        for (int i = index; i < word.length(); i++) {

            if (curr.children.containsKey(word.charAt(i))) {
                Node n = curr.children.get(word.charAt(i));
                return searchUtil(n, word, index + 1);
            } else if (word.charAt(i) == '.') {
                boolean val = false;
                for(Node c : curr.children.values()) {
                    val = val || searchUtil(c, word, index + 1);
                }
                return val;
            } else {
                return false;
            }
        }
        return false;
    }
}

class Node {
    Character c;
    boolean isEndOfWord;
    Map<Character, Node> children;

    public Node(Character c) {
        this.c = c;
        this.children = new HashMap();
    }
}
