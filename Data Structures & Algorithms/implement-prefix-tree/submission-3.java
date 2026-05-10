class PrefixTree {
    class Node {
        Node[] nextNodes;
        boolean end;
        Node() {
            nextNodes = new Node[26];
            end = false;
        }
    }
    Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.nextNodes[c - 'a'] == null) {
                cur.nextNodes[c - 'a'] = new Node();
            }
            cur = cur.nextNodes[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.nextNodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.nextNodes[c - 'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String word) {
 Node cur = root;
        for (char c: word.toCharArray()) {
            if (cur.nextNodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.nextNodes[c - 'a'];
        }
        return true;
    }
}
