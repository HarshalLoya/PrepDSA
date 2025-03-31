
import java.util.Arrays;

public class PrintAllPermutations {

    // appraoch 1: TC->O(N*N!)
    // SC-> O(N) for list and array and O(N) for recursion stack as there are a max of N numbers to permute
    // so overall SC: O(N)
    // public static void allPermutations(int[] arr, List<Integer> list, boolean[] picked) {
    //     /*Here's how this works. Think of using a stack to store the ans. We push those elements in the stack which have not been picked before. Now to track whether an element is picked or not we use a boolean array. We print the answer when the size of the stack becomes equal to the size of the given array (meaning all elements have been picked). We remove (pop) the last element of the list after generating all permutations available for that index/element (pop the last element when going up a level in the recursion tree every time)*/
    //     if (list.size() == arr.length) {
    //         System.out.println(list);
    //         return;
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         if (!picked[i]) {
    //             picked[i] = true;
    //             list.add(arr[i]);
    //             allPermutations(arr, list, picked);
    //             list.remove(list.size() - 1);
    //             picked[i] = false;
    //         }
    //     }
    // }

    // appraoch 2: TC->O(N*N!) as we are generating all permutations
    // SC-> O(N) for list and array and O(N) for recursion stack as there are a max of N numbers to permute so overall SC: O(N)
    // We do not use any extra data structure like we did in the previous approach
    public static void allPermutations(int[] arr, int n, int i) {
        if (i == n) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int j = i; j < n; j++) {
            swap(arr, i, j);
            allPermutations(arr, n, i + 1);
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // approach 1
        // List<Integer> list = new ArrayList<>();
        // boolean[] picked = new boolean[arr.length];
        // allPermutations(arr, list, picked);
        // approach 2
        allPermutations(arr, arr.length, 0);
    }
}
