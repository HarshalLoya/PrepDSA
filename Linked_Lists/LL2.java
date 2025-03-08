
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

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 78, 134, 6};
        LL2 linkedlist = new LL2();
        linkedlist.convertArrToLL(arr);
        linkedlist.display();
        linkedlist.insertAtStart(101);
        linkedlist.display();
    }
}
