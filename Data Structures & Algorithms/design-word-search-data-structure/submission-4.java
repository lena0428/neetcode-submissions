class WordDictionary {
    class Node {
        Node[] nodes;
        boolean existed;
        Node() {
            nodes = new Node[26];
            existed = false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.nodes[c - 'a'] == null) {
                cur.nodes[c - 'a'] = new Node();
            }
            cur = cur.nodes[c - 'a'];
        }
        cur.existed = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node cur) {
        if (index == word.length()) {
            return cur.existed;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node neighbor: cur.nodes) {
                if (neighbor == null) {
                    continue;
                }
                if (dfs(word, index + 1, neighbor)) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.nodes[c - 'a'] == null) {
                return false;
            } 
           return dfs(word, index + 1, cur.nodes[c - 'a']);
        }
    }
}
