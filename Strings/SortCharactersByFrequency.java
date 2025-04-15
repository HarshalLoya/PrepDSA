
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {

    // Overall TC: O(NlogN), in average or worst case: O(N + KlogK), SC: O(N)
    // public static String frequencySort(String s) {
    //     if (s == null || s.isEmpty()) {
    //         return "";
    //     }
    //     Map<Character, Integer> map = new HashMap<>(); // O(N)
    //     for (char c : s.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet()); // O(K) if there are k distinct characters
    //     Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue())); // O(KlogK)
    //     StringBuilder sb = new StringBuilder(); // O(N)
    //     for (Map.Entry<Character, Integer> entry : list) {
    //         for (int i = 0; i < entry.getValue(); i++) {
    //             sb.append(entry.getKey());
    //         }
    //     }
    //     return sb.toString();
    // }

    // using streams api, overall: TC: O(N), SC: O(N) for resulting string and O(1) for frequency map since k is bounded
    public static String frequencySort(String s) {
        // Step 1: Build a frequency map using streams.
        Map<Character, Long> freqMap = s.chars()
            .mapToObj(c -> (char) c) // Convert int stream to Character stream.
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Step 2: Sort the frequency map entries in descending order,
        // then build the string by repeating each character according to its frequency.
        return freqMap.entrySet().stream()
            .sorted(Map.Entry.<Character, Long>comparingByValue(Comparator.reverseOrder()))
            .map(e -> String.valueOf(e.getKey()).repeat(e.getValue().intValue()))
            .collect(Collectors.joining());
    }

    // Overall TC: O(N), SC: O(N)
    // public static String frequencySort(String s) {
    //     int n = s.length();
    //     if (n == 0) {
    //         return "";
    //     }
    //     int[] freq = new int[128];
    //     for (char c : s.toCharArray()) { // counting frequencies -> O(N)
    //         freq[c]++;
    //     }
    //     List<Character>[] buckets = new ArrayList[n + 1]; // bucket construction O(128) -> O(1) in practical terms
    //     for (int i = 0; i < 128; i++) {
    //         if (freq[i] > 0) {
    //             int f = freq[i];
    //             if (buckets[f] == null) {
    //                 buckets[f] = new ArrayList<>();
    //             }
    //             buckets[f].add((char) i);
    //         }
    //     }
    //     StringBuilder sb = new StringBuilder(); // O(N)
    //     for (int i = buckets.length - 1; i > 0; i--) {
    //         if (buckets[i] != null) {
    //             for (char c : buckets[i]) {
    //                 for (int j = 0; j < i; j++) {
    //                     sb.append(c);
    //                 }
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }

    public static void main(String[] args) {
        String s = "HelloWorld133";
        System.out.println(frequencySort(s));
    }
}
