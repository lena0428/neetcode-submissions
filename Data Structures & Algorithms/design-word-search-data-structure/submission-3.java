class WordDictionary {
    class Node {
        Node[] nodes;
        boolean end;
        Node() {
            nodes = new Node[26];
        }
    }

    Node root = new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
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
        return dfs(word, 0 ,root);
    }

    public boolean dfs(String word, int index, Node cur) {
        if (index == word.length()) {
            return cur.end;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node node : cur.nodes) {
                if (node != null && dfs(word, index + 1, node)) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.nodes[word.charAt(index) - 'a'] == null) {
                return false;
            }
            return dfs(word, index + 1, cur.nodes[word.charAt(index) - 'a']);
        }
    }
}
