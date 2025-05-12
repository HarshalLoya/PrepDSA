
import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // TC: O( (2^n) *k*(n/2) ), reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.
    // SC: O(k * x) The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n). 
    public static void backtrack(int ind, String str, List<String> curr, List<List<String>> res) {
        if (ind == str.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = ind; i < str.length(); i++) {
            if (isPalindrome(str.substring(ind, i + 1))) {
                curr.add(str.substring(ind, i + 1));
                backtrack(i + 1, str, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        String s = "aabb";
        for (List<String> str : partition(s)) {
            System.out.println(str);
        }
    }
}
