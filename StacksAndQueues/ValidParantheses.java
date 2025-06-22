
import java.util.Stack;

public class ValidParantheses {

    // TC: O(N), SC: O(N), the space complexity can be improved to O(N/2)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' ->
                    stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Example test cases from the prompt
        test("()", true);
        test("()[]{}", true);
        test("(]", false);
        test("([])", true);

        // Additional test cases
        test("", true);          // empty string (trivially valid)
        test("(((((", false);    // only opens
        test("}}}}", false);     // only closes
        test("{[()]}", true);    // nested properly
        test("{[(])}", false);   // wrong nesting
        test("()({[]})", true);  // mixed nesting
        test("([)]", false);     // interleaved incorrectly
        test("(([]){})", true);  // complex but valid
        test("(([]){})]", false);// extra closing
        test("[", false);        // single open
        test("]", false);        // single close
        test("()()()()()", true);// repeated pairs
        test("([{}])(){}[]", true);// multiple valid groups
    }

    private static void test(String s, boolean expected) {
        boolean result = isValid(s);
        System.out.printf("Input: %-12s Expected: %-5b Result: %-5b %s%n",
                "\"" + s + "\"", expected, result,
                result == expected ? "✔" : "✘");
    }
}
