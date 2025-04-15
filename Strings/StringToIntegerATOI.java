
public class StringToIntegerATOI {

    // TC: O(N), SC: O(N) but O(1) if we ignore the extra space used for the trimmed string
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0, i = 0, sign = 1;

        char fchar = s.charAt(0);
        if (fchar == '-' || fchar == '+') {
            if (fchar == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }

        return sign * res;
    }

    public static void main(String[] args) {
        // Example test cases.
        String[] testCases = {
            "42", // Expected: 42
            " -042", // Expected: -42
            "1337c0d3", // Expected: 1337
            "0-1", // Expected: 0 (stops at the non-digit '-')
            "words and 987", // Expected: 0 (first non-space char is not a digit or sign)
            "   000123", // Expected: 123
            "2147483648", // Expected: 2147483647 (overflow test)
            "-91283472332" // Expected: -2147483648 (overflow test)
        };

        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\" Output: " + myAtoi(testCase));
        }
    }
}
