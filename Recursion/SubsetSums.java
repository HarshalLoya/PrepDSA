
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSums {

    // TC: O(2^N) + O(2^Nlog(2^N)), (finding sums of all subsets, sorting the sum arrays (has 2^n elements))
    // SC: O(2^N) + O(N), (sumlist, depth of recursion stack)
    private static void generateSubsetSums(int index, int currentSum, int[] arr, List<Integer> sums) {
        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }

        // Include current element
        generateSubsetSums(index + 1, currentSum + arr[index], arr, sums);

        // Exclude current element
        generateSubsetSums(index + 1, currentSum, arr, sums);
    }

    public static List<Integer> subsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        generateSubsetSums(0, 0, arr, sums);
        Collections.sort(sums);
        return sums;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        List<Integer> result = subsetSums(arr);

        System.out.println("Subset sums in ascending order:");
        for (int sum : result) {
            System.out.print(sum + " ");
        }
    }
}
