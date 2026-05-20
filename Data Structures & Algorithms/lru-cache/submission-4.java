
class LRUCache {
    class Node {
        int value;
        int key;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node tail;
        Node head;
        int size;
        int capacity;
        DoubleLinkedList(int capacity) {
            tail = new Node(-1, -1);
            head = new Node(-1, -1);
            tail.prev = head;
            head.next = tail;
            size = 0;
            this.capacity = capacity;
        }

        private void addNode(Node node) {
            // head node next
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            size++;
        }

        private void removeNode(Node node) {
            // prev node next
            Node next = node.next;
            Node prev = node.prev;
            next.prev = prev;
            prev.next = next;
            size--;
        }
    }

    HashMap<Integer, Node> map;
    DoubleLinkedList dll;

    public void addNode(Node node) {
        if (map.containsKey(node.key)) {
            Node oldNode = map.get(node.key);
            map.remove(node.key);
            dll.removeNode(oldNode);
            dll.addNode(node);
            map.put(node.key, node);
        } else {
            map.put(node.key, node);
            dll.addNode(node);
        }

    }

    public void removeNode(Node node) {
        map.remove(node.key);
        dll.removeNode(node);
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        dll = new DoubleLinkedList(capacity);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (dll.size == dll.capacity) {
                removeNode(dll.tail.prev);
                addNode(new Node(key, value));
            } else {
                addNode(new Node(key, value));
            }
        } else {
            Node node = map.get(key);
            removeNode(node);
            addNode(new Node(key, value));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */