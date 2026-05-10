/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // old node map to new node
        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);
        // create the nodes
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            Node newNode = new Node(tmp.val);
            newNode.neighbors = new ArrayList<>();
            map.put(tmp, newNode);
            for (Node neighbor: tmp.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        set.clear();
        queue.offer(node);
        set.add(node);
        // create the relationship
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            Node newNode = map.get(tmp);
            for (Node neighbor: tmp.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return map.get(node);
    }
}