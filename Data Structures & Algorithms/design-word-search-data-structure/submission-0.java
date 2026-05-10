class WordDictionary {
    class Node {
        Node[] existed;
        boolean end;
        Node() {
            existed = new Node[26];
            end = false;
        }
    }
    Node root = new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node root) {
        if (index == word.length()) {
            return root.end;
        }
        if (word.charAt(index) == '.') {
            for (Node child: root.existed) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            char c = word.charAt(index);
            if (root.existed[c - 'a'] == null) {
                return false;
            }
            return dfs(word, index + 1, root.existed[c - 'a']);
        }
    }
}
