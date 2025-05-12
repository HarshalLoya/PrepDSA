
import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    // TC: O(N * 2^N), SC: O(N * 2^N)
    public static List<List<Integer>> getAllSubsets(int[] arr) {
        int n = arr.length;
        int totalSubsets = 1 << n;
        List<List<Integer>> allSubsets = new ArrayList<>();

        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                }
            }
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        List<List<Integer>> subsets = getAllSubsets(arr);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
