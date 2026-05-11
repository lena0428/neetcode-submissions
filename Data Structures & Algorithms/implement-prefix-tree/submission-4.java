class PrefixTree {
    class Node {
        Node[] nodes;
        boolean end;
        Node() {
            nodes = new Node[26];
            
        }
    }

    Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.nodes[c - 'a'] == null) {
                cur.nodes[c - 'a'] = new Node();
            }
            cur = cur.nodes[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.nodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.nodes[c - 'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c: prefix.toCharArray()) {
            if (cur.nodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.nodes[c - 'a'];
        }
        return true;
    }
}
