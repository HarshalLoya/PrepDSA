
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 5};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));

        // Brute force using a HashSet (this will work in case of an unsorted array too)
        // This take O(nlogn) + O(n) time complexity in cpp but O(n) in java
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        System.out.println("Removing duplicates using hashset");
        System.out.println(set);

        // Optimal using the two pointer method
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        System.out.println("Removing duplicates using two pointer method");
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, i + 1)));
    }
}
