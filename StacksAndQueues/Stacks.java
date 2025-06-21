
import java.util.LinkedList;
import java.util.Queue;

// Array based implementation of stack
class ArrayStack<T> {

    private final T[] stack;
    private int top;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        capacity = size;
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T item) {
        if (top >= capacity) {
            throw new RuntimeException("Stack Overflow");
        }
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stack[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

// LinkedList based implementation of stack
class LinkedListStack<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}

// Queue based implementation of stack: using 2 queues, making push operation O(n)
class StackUsingQueue<T> {

    private Queue<T> q1;
    private Queue<T> q2;
    private int size;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }

    public void push(T item) {
        q2.offer(item);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        size--;
        return q1.poll();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return size;
    }

}

// Queue based implementation:  using one queue with rotation technique
class StackUsingSingleQueue<T> {

    private final Queue<T> queue;

    public StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    public void push(T item) {
        int size = queue.size();
        queue.offer(item);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return queue.poll();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}

public class Stacks {

    public static void main(String[] args) {

        System.out.println("\nTesting array based implementation");
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println("Stack size: " + arrayStack.size());
        System.out.println("Top element: " + arrayStack.peek());
        System.out.println("Popped element: " + arrayStack.pop());
        System.out.println("Stack size after pop: " + arrayStack.size());
        System.out.println("Is stack empty? " + arrayStack.isEmpty());
        arrayStack.pop();
        arrayStack.pop();
        System.out.println("Is stack empty? " + arrayStack.isEmpty());

        System.out.println("\nTesting linked list based implementation");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println("Stack size: " + linkedListStack.size());
        System.out.println("Top element: " + linkedListStack.peek());
        System.out.println("Popped element: " + linkedListStack.pop());
        System.out.println("Stack size after pop: " + linkedListStack.size());
        System.out.println("Is stack empty? " + linkedListStack.isEmpty());
        linkedListStack.pop();
        linkedListStack.pop();
        System.out.println("Is stack empty? " + linkedListStack.isEmpty());

        System.out.println("\nTesting queue (two queues) based implementation");
        StackUsingQueue<Integer> queueStack = new StackUsingQueue<>();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        System.out.println("Stack size: " + queueStack.size());
        System.out.println("Top element: " + queueStack.peek());
        System.out.println("Popped element: " + queueStack.pop());
        System.out.println("Stack size after pop: " + queueStack.size());
        System.out.println("Is stack empty? " + queueStack.isEmpty());
        queueStack.pop();
        queueStack.pop();
        System.out.println("Is stack empty? " + queueStack.isEmpty());

        System.out.println("\nTesting queue (single queue) based implementation");
        StackUsingSingleQueue<Integer> singleQueueStack = new StackUsingSingleQueue<>();
        singleQueueStack.push(1);
        singleQueueStack.push(2);
        singleQueueStack.push(3);
        System.out.println("Stack size: " + singleQueueStack.size());
        System.out.println("Top element: " + singleQueueStack.peek());
        System.out.println("Popped element: " + singleQueueStack.pop());
        System.out.println("Stack size after pop: " + singleQueueStack.size());
        System.out.println("Is stack empty? " + singleQueueStack.isEmpty());
        singleQueueStack.pop();
        singleQueueStack.pop();
        System.out.println("Is stack empty? " + singleQueueStack.isEmpty());
    }
}
