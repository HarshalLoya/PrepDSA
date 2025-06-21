
// Array based implementatin of queue
import java.util.Stack;

class ArrayQueue<T> {

    private final T[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (size >= capacity) {
            throw new RuntimeException("Queue overflow");
        }

        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        T data = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

// Linked list based implementation of queue
class LinkedListQueue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue underflow");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}

// Stack based implementation of queue: uses two stacks, making dequeue amortized O(1)
class QueueUsingStack<T> {

    private final Stack<T> s1;
    private final Stack<T> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(T item) {
        s1.push(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int size() {
        return s1.size() + s2.size();
    }
}

// Stack based implementation of queue: makes enqueue O(n) but dequeue O(1)
class QueueUsingStackExpensiveEnqueue<T> {

    final private Stack<T> s1;
    final private Stack<T> s2;

    public QueueUsingStackExpensiveEnqueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(T item) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(item);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return s1.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public int size() {
        return s1.size();
    }
}

public class Queues {

    public static void main(String[] args) {
        System.out.println("\nTesting array based implementation of queue");
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(100);
        System.out.println("Size of queue: " + arrayQueue.size());
        System.out.println("Peeking: " + arrayQueue.peek());
        System.out.println("Dequeuing: " + arrayQueue.dequeue());
        System.out.println("Size of queue: " + arrayQueue.size());
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        System.out.println("Is empty: " + arrayQueue.isEmpty());

        System.out.println("\nTesting linked list based implementation of queue");
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(100);
        System.out.println("Size of queue: " + linkedListQueue.size());
        System.out.println("Peeking: " + linkedListQueue.peek());
        System.out.println("Dequeuing: " + linkedListQueue.dequeue());
        System.out.println("Size of queue: " + linkedListQueue.size());
        linkedListQueue.dequeue();
        linkedListQueue.dequeue();
        System.out.println("Is empty: " + linkedListQueue.isEmpty());

        System.out.println("\nTesting linked list based implementation of queue");
        QueueUsingStack<Integer> stackQueue = new QueueUsingStack<>();
        stackQueue.enqueue(1);
        stackQueue.enqueue(10);
        stackQueue.enqueue(100);
        System.out.println("Size of queue: " + stackQueue.size());
        System.out.println("Peeking: " + stackQueue.peek());
        System.out.println("Dequeuing: " + stackQueue.dequeue());
        System.out.println("Size of queue: " + stackQueue.size());
        stackQueue.dequeue();
        stackQueue.dequeue();
        System.out.println("Is empty: " + stackQueue.isEmpty());

        System.out.println("\nTesting linked list based implementation of queue");
        QueueUsingStackExpensiveEnqueue<Integer> expensiveStackQueue = new QueueUsingStackExpensiveEnqueue<>();
        expensiveStackQueue.enqueue(1);
        expensiveStackQueue.enqueue(10);
        expensiveStackQueue.enqueue(100);
        System.out.println("Size of queue: " + expensiveStackQueue.size());
        System.out.println("Peeking: " + expensiveStackQueue.peek());
        System.out.println("Dequeuing: " + expensiveStackQueue.dequeue());
        System.out.println("Size of queue: " + expensiveStackQueue.size());
        expensiveStackQueue.dequeue();
        expensiveStackQueue.dequeue();
        System.out.println("Is empty: " + expensiveStackQueue.isEmpty());

    }
}
