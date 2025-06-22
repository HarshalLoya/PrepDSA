
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

    // my approach
    // TC: O(N2) + O(N2) + O(N1) => (map, nge, ans)
    // SC: O(N2) + O(N2) + O(N2) + O(N1) => (map, nge, stack, ans)
    // public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int n1 = nums1.length, n2 = nums2.length;
    //     int[] ans = new int[n1];
    //     int[] nge = new int[n2];
    //     Map<Integer, Integer> map = new HashMap<>();
    //     Stack<Integer> stack = new Stack<>();

    //     for (int i = 0; i < n2; i++) {
    //         map.put(nums2[i], i);
    //     }

    //     nge[n2 - 1] = -1;
    //     stack.push(nums2[n2 - 1]);
    //     for (int i = n2 - 2; i >= 0; i--) {
    //         while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
    //             stack.pop();
    //         }
    //         if (!stack.isEmpty()) {
    //             nge[i] = stack.peek();
    //         } else {
    //             nge[i] = -1;
    //         }
    //         stack.push(nums2[i]);
    //     }

    //     for (int i = 0; i < n1; i++) {
    //         ans[i] = nge[map.get(nums1[i])];
    //     }

    //     return ans;
    // }

    // gpt approach
    // TC: O(N1 + N2), sc: O(N2) for stack and hashmap
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map from value in nums2 -> its next greater element (or -1 if none)
        Map<Integer, Integer> nextGreater = new HashMap<>(nums2.length);

        // Monotonic decreasing stack (holds values from nums2)
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse nums2: for each num, pop smaller elements and record their next greater = num
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        // Remaining elements in stack have no greater to their right
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        // Build answer for nums1 by lookup in the map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Guaranteed to be present in nums2, hence in nextGreater
            ans[i] = nextGreater.get(nums1[i]);
        }
        return ans;
    }

    private static void runTest(int[] nums1, int[] nums2, int[] expected) {
        int[] result = nextGreaterElement(nums1, nums2);
        boolean pass = Arrays.equals(result, expected);
        System.out.printf("nums1=%s, nums2=%s -> got=%s, expected=%s %s%n",
                Arrays.toString(nums1),
                Arrays.toString(nums2),
                Arrays.toString(result),
                Arrays.toString(expected),
                pass ? "✔" : "✘");
    }

    public static void main(String[] args) {
        // Provided examples
        runTest(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2},
                new int[]{-1, 3, -1}
        );

        runTest(
                new int[]{2, 4},
                new int[]{1, 2, 3, 4},
                new int[]{3, -1}
        );

        // Additional test cases
        // 1. All elements have the same next greater
        runTest(
                new int[]{1, 2, 3},
                new int[]{3, 2, 1, 4},
                new int[]{4, 4, 4}
        );

        // 2. Strictly decreasing nums2: no next greater for anyone
        runTest(
                new int[]{5, 1},
                new int[]{5, 4, 3, 2, 1},
                new int[]{-1, -1}
        );

        // 3. nums1 equals nums2
        runTest(
                new int[]{1, 3, 2, 5, 4},
                new int[]{1, 3, 2, 5, 4},
                new int[]{3, 5, 5, -1, -1}
        );

        // 4. Single-element arrays
        runTest(
                new int[]{10},
                new int[]{10},
                new int[]{-1}
        );
    }
}
