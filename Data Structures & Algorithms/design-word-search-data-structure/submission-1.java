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

    public boolean dfs(String word, int curIndex, Node cur) {
        if (curIndex == word.length()) {
            return cur.end;
        }
        char c = word.charAt(curIndex);
        if (c == '.') {
            for (Node child: cur.existed) {
                if (child != null && dfs(word, curIndex + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.existed[c - 'a'] == null) {
                return false;
            }
            return dfs(word, curIndex + 1, cur.existed[c - 'a']);
        }
    }
}
