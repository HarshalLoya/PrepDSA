
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {

        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    // left sentinel: left.next points to the LRU node
    private final Node left;
    // right sentinel: right.prev points to the Most Recently Used node
    private final Node right;
    // A map where the key points directly to the node for O(1) access
    private final Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize dummy nodes
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        // Move accessed node to the most recent position (right end)
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode); // Add to the most recent position

            if (cache.size() > capacity) {
                // Evict the least recently used node (the one after the left dummy)
                Node lru = this.left.next;
                removeNode(lru);
                cache.remove(lru.key);
            }
        } else {
            node.value = value;
            // Move updated node to the most recent position
            removeNode(node);
            addNode(node);
        }
    }

    public void addNode(Node node) {
        node.next = right;
        node.prev = right.prev;
        right.prev.next = node;
        right.prev = node;
    }

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {
        // Input: ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        // Args:  [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        LRUCache lruCache = new LRUCache(2);
        System.out.println("LRUCache(2): null");

        lruCache.put(1, 1);
        System.out.println("put(1, 1):   null");

        lruCache.put(2, 2);
        System.out.println("put(2, 2):   null");

        int val1 = lruCache.get(1);
        System.out.println("get(1):      " + val1); // Expected: 1

        lruCache.put(3, 3);
        System.out.println("put(3, 3):   null"); // Evicts key 2

        int val2 = lruCache.get(2);
        System.out.println("get(2):      " + val2); // Expected: -1

        lruCache.put(4, 4);
        System.out.println("put(4, 4):   null"); // Evicts key 1

        int val3 = lruCache.get(1);
        System.out.println("get(1):      " + val3); // Expected: -1

        int val4 = lruCache.get(3);
        System.out.println("get(3):      " + val4); // Expected: 3

        int val5 = lruCache.get(4);
        System.out.println("get(4):      " + val5); // Expected: 4
    }
}
