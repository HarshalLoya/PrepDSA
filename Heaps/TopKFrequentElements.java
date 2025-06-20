
import java.util.*;

public class TopKFrequentElements {

    // Heap approach
    // TC: O(N + MlogK), SC: O(M + K)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }

    // Bucket sort approach
    // public static List<Integer> topKFrequent(int[] nums, int k) {
    //     // 1) Count frequencies
    //     Map<Integer, Integer> freqMap = new HashMap<>();
    //     for (int num : nums) {
    //         freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    //     }

    //     int maxFreq = Collections.max(freqMap.values());

    //     // 2) Create buckets: index = frequency, value = list of numbers
    //     // Consider using List<List<Integer>> to avoid unchecked array creation
    //     @SuppressWarnings("unchecked")
    //     List<Integer>[] buckets = new List[maxFreq + 1];
    //     for (int i = 0; i <= maxFreq; i++) {
    //         buckets[i] = new ArrayList<>();
    //     }
    //     for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
    //         buckets[entry.getValue()].add(entry.getKey());
    //     }

    //     // 3) Gather top k frequent from buckets
    //     List<Integer> result = new ArrayList<>(k);
    //     for (int i = maxFreq; i > 0 && result.size() < k; i--) {
    //         for (int num : buckets[i]) {
    //             result.add(num);
    //             if (result.size() == k) {
    //                 break;

    //             }
    //         }
    //     }
    //     return result;
    // }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Test1 output: " + Arrays.toString(topKFrequent(nums1, 2))); // [1,2]

        int[] nums2 = {1};
        System.out.println("Test2 output: " + Arrays.toString(topKFrequent(nums2, 1))); // [1]

        int[] nums3 = {4, 1, -1, 2, -1, 2, 3};
        System.out.println("Test3 output: " + Arrays.toString(topKFrequent(nums3, 2))); // [-1,2]

        int[] nums4 = {5, 3, 1, 1, 1, 3, 73, 1};
        System.out.println("Test4 output: " + Arrays.toString(topKFrequent(nums4, 2))); // [1,3]
    }
}
