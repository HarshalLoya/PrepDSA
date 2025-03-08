
public class LL2 {

    private Node head;

    private class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        // public Node(int data, Node next) {
        //     this.data = data;
        //     this.next = next;
        // }
    }

    public void convertArrToLL(int[] arr) {
        Node curr = new Node(arr[0]);
        head = curr;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            curr = newNode;
        }
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    public void deleteByPosition(int position) {
        if (head == null) {
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node node = head;
        for (int i = 0; i < position - 1; i++) {
            node = node.next;
        }
        if (node == null || node.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        node.next = node.next.next;
    }

    public void deleteByVal(int val) {
        if (head == null) {
            return;
        }
        if (head.data == val) {
            head = head.next;
            return;
        }
        Node current = head;
        Node prev = null;

        while (current != null && current.data != val) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }
        prev.next = current.next;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6};
        LL2 ll = new LL2();
        ll.convertArrToLL(arr);
        ll.display();
        ll.insertAtStart(12);
        ll.display();
        ll.insertAtEnd(15);
        ll.display();
        // incase we are not given access to the head of the linked list and only given the reference to the node to be deleted then (Node node), then
        // node.data = node.next.data, copying the data of the next node in the ll
        // node.next = node.next.next, making the current node poin to the next to next node in the ll
        ll.deleteByPosition(4);
        ll.display();
        ll.deleteByVal(15);
        ll.display();
    }
}
