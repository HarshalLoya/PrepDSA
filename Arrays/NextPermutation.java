
import java.util.Arrays;

// OPTIMAL APPROACH, OVERALL TC: O(N), SC: O(1)
public class NextPermutation {

    public static int findBreakPoint(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        int n = nums.length;

        int breakpoint = findBreakPoint(nums);
        System.out.println(breakpoint);

        if (breakpoint == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = n - 1; i >= breakpoint; i--) {
                if (nums[i] > nums[breakpoint]) {
                    swap(nums, i, breakpoint);
                    break;
                }
            }
            reverse(nums, breakpoint + 1, n - 1);
        }
        System.out.println(Arrays.toString(nums));
    }
}

// BRUTE FORCE METHOD, OVERALL TC: O(N*N!), SC: O(N*N!)
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;
// public class NextPermutation {
//     /*This approach involved finding all the permutations and storing them. then we looked for the given array in the stored permutations and printed the next one. if the given array was the last permutation, then printed the first permutation*/
//     // method to find and store all permutations of the given array
//     public static void findPermutations(int[] nums, List<List<Integer>> list, int n, int i) {
//         if (i == n) {
//             list.add(new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
//         }
//         for (int j = i; j < n; j++) {
//             swap(nums, i, j);
//             findPermutations(nums, list, n, i + 1);
//             swap(nums, i, j);
//         }
//     }
//     // swapping method
//     public static void swap(int[] arr, int a, int b) {
//         int temp = arr[a];
//         arr[a] = arr[b];
//         arr[b] = temp;
//     }
//     // method to get the next permutation
//     private static void getNextPermutation(int[] nums, List<List<Integer>> list) {
//         List<Integer> ans = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
//         for (int i = 0; i < list.size(); i++) {
//             if (list.get(i).equals(ans)) {
//                 if (i == list.size() - 1) {
//                     System.out.println(list.get(0));
//                     return;
//                 } else {
//                     ans = list.get(i + 1);
//                     System.out.println(ans);
//                     return;
//                 }
//             }
//         }
//     }
//     public static void main(String[] args) {
//         int[] nums = {1, 2, 3};
//         List<List<Integer>> list = new ArrayList<>();
//         findPermutations(nums, list, nums.length, 0);
//         System.out.println(list);
//         getNextPermutation(nums, list);
//     }
// }
