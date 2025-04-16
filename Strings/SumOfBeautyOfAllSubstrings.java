
public class SumOfBeautyOfAllSubstrings {

    // TC: O(N^2), SC: O(1)
    public static int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq[c - 'a']++;
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }
                totalBeauty += (max - min);
            }
        }
        return totalBeauty;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }
}
