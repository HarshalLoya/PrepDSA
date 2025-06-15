
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            if (cache.size() > capacity) {
                Node tailNode = popTail();
                cache.remove(tailNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("--- LRU Cache Example ---");
        LRUCache lruCache = new LRUCache(2);

        System.out.println("put(1, 1)");
        lruCache.put(1, 1);

        System.out.println("put(2, 2)");
        lruCache.put(2, 2);

        System.out.println("get(1): " + lruCache.get(1));

        System.out.println("put(3, 3)");
        lruCache.put(3, 3);

        System.out.println("get(2): " + lruCache.get(2));
        System.out.println("put(4, 4)");
        lruCache.put(4, 4);

        System.out.println("get(1): " + lruCache.get(1));
        System.out.println("get(3): " + lruCache.get(3));
        System.out.println("get(4): " + lruCache.get(4));
    }
}
