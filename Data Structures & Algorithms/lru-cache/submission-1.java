class LRUCache {
    class Node{
        int val;
        int key;
        Node next;
        Node prev;
        Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> cache;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    // hashmap
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // removeNode
        int val = cache.get(key).val;
        removeNode(key);
        // addToFront
        addToFront(key, val);
        return val;
    }
    
    // put to the front
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            removeNode(key);
            addToFront(key, value);
        } else {
            if (this.capacity == cache.size()) {
                removeNode(tail.prev.key);
            } 
            addToFront(key, value);
        }
    }

    private void removeNode(int key) {
        Node tmp = cache.get(key);
        cache.remove(key);
        // prev -> tmp -> next
        Node prev = tmp.prev;
        Node next = tmp.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToFront(int key, int value) {
        Node tmp = new Node(value, key);
        cache.put(key, tmp);
        // head -> tmp -> next
        Node next = head.next;
        head.next = tmp;
        tmp.prev = head;
        tmp.next = next;
        next.prev = tmp;
    }
}
