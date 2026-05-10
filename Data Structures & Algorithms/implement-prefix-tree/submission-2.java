class PrefixTree {

    class Node {
        private Node[] existed;
        private boolean end;
        Node() {
            existed = new Node[26];
            end = false;
        }
    }

    private Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.existed[c - 'a'] == null) {
                cur.existed[c - 'a'] = new Node();
            }
            cur = cur.existed[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.existed[c - 'a'] == null) {
                return false;
            }
            cur = cur.existed[c - 'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c: prefix.toCharArray()) {
            if (cur.existed[c - 'a'] == null) {
                return false;
            }
            cur = cur.existed[c - 'a'];
        }
        return true;
    }
}
