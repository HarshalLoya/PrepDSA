
public class ReverseWordsInString {

    // brute force approach, TC: O(N), SC: O(N)
    // private static String reverseWordsInString(String s) {
    //     Stack<String> stack = new Stack<>();
    //     s += " ";
    //     String str = "";
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == ' ') {
    //             stack.push(str);
    //             str = "";
    //         } else {
    //             str += s.charAt(i);
    //         }
    //     }
    //     System.out.println(stack);
    //     String ans = "";
    //     while (stack.size() != 1) {
    //         ans = stack.pop() + " " + ans;
    //     }
    //     return ans + stack.pop();
    // }

    // optimized approach, TC: O(N), DC: O(1)
    // public static String reverseWordsInString(String s) {
    //     int left = 0, right = s.length() - 1;
    //     String temp = "";
    //     String ans = "";
    //     while (left <= right) {
    //         char ch = s.charAt(left);
    //         if (ch != ' ') {
    //             temp += ch;
    //         } else if (ch == ' ') {
    //             if (!ans.equals("")) {
    //                 ans = temp + " " + ans;
    //             } else {
    //                 ans = temp;
    //             }
    //             temp = "";
    //         }
    //         left++;
    //     }
    //     if (!temp.equals("")) {
    //         if (!ans.equals("")) {
    //             ans = temp + " " + ans;
    //         } else {
    //             ans = temp;
    //         }
    //     }
    //     return ans;
    // }

    // optimized approach 2, using StringBuilder, TC: O(N), SC: O(N)
    public static String reverseWordsInString(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("Before reversing the words: " + s);
        s = reverseWordsInString(s);
        System.out.println("After reversing the words: " + s);
    }
}
