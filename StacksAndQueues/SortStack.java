
import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> aux = new Stack<>();

        while (!input.isEmpty()) {
            int curr = input.pop();

            // Move elements from aux back to input until we find the right spot
            while (!aux.isEmpty() && aux.peek() > curr) {
                input.push(aux.pop());
            }

            aux.push(curr);
        }

        // At this point, aux has the elements in descending order
        // (largest on top). To have the smallest on top, reverse it back.
        while (!aux.isEmpty()) {
            input.push(aux.pop());
        }

        return input;
    }

    public static void main(String[] args) {
        // Test case 1: random order
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(1);
        s1.push(4);
        s1.push(2);
        System.out.println("Original s1: " + s1);
        Stack<Integer> sortedS1 = sortStack(s1);
        System.out.println("Sorted   s1: " + sortedS1);
        System.out.println();

        // Test case 2: already sorted
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);
        System.out.println("Original s2: " + s2);
        System.out.println("Sorted   s2: " + sortStack(s2));
        System.out.println();

        // Test case 3: reverse sorted
        Stack<Integer> s3 = new Stack<>();
        s3.push(5);
        s3.push(4);
        s3.push(3);
        s3.push(2);
        s3.push(1);
        System.out.println("Original s3: " + s3);
        System.out.println("Sorted   s3: " + sortStack(s3));
        System.out.println();

        // Test case 4: with duplicates
        Stack<Integer> s4 = new Stack<>();
        s4.push(2);
        s4.push(3);
        s4.push(2);
        s4.push(1);
        s4.push(3);
        System.out.println("Original s4: " + s4);
        System.out.println("Sorted   s4: " + sortStack(s4));
        System.out.println();

        // Test case 5: single element
        Stack<Integer> s5 = new Stack<>();
        s5.push(42);
        System.out.println("Original s5: " + s5);
        System.out.println("Sorted   s5: " + sortStack(s5));
        System.out.println();

        // Test case 6: empty stack
        Stack<Integer> s6 = new Stack<>();
        System.out.println("Original s6: " + s6);
        System.out.println("Sorted   s6: " + sortStack(s6));
    }
}
