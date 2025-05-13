
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    // brute force appraoch, finding and storing all permutations, then sorting them and then returning the kth one
    // TC: O(N! * N) +O(N! Log N!)
    // SC: O(N! * N) + O(N)
    // static void permutationHelper(char s[], int index, ArrayList< String> res) {
    //     if (index == s.length) {
    //         String str = new String(s);
    //         res.add(str);
    //         return;
    //     }
    //     for (int i = index; i < s.length; i++) {
    //         swap(s, i, index);
    //         permutationHelper(s, index + 1, res);
    //         swap(s, i, index);
    //     }
    // }
    // static void swap(char s[], int i, int j) {
    //     char ch = s[i];
    //     s[i] = s[j];
    //     s[j] = ch;
    // }
    // static String getPermutation(int n, int k) {
    //     String s = "";
    //     ArrayList< String> res = new ArrayList<>();
    //     for (int i = 1; i <= n; i++) {
    //         s += i;
    //     }
    //     permutationHelper(s.toCharArray(), 0, res);
    //     Collections.sort(res);
    //     return res.get(k - 1);
    // }


    // optimized approach, TC: O(N^2), SC: O(N)
    public static String getPermutation(int n, int k) {
        String ans = "";

        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);

        k = k - 1;

        while (true) {
            ans = ans + nums.get(k / fact);
            nums.remove(k / fact);
            if (nums.isEmpty()) {
                break;
            }
            k = k % fact;
            fact = fact / nums.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4, k = 17;
        System.out.println(getPermutation(n, k));
    }
}
