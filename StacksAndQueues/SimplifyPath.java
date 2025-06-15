
import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    // TC: O(N), SC: O(N)
    public static String simplifyPath(String path) {
        String[] parts = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();

        for (String part : parts) {
            switch (part) {
                case "", "." -> {
                }
                case ".." -> {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    }
                }
                default ->
                    stack.addLast(part);
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String[] paths = {
            "/home/",
            "/home//foo/",
            "/home/user/Documents/../Pictures",
            "/../",
            "/.../a/../b/c/../d/./"
        };

        String[] expected = {
            "/home",
            "/home/foo",
            "/home/user/Pictures",
            "/",
            "/.../b/d"
        };

        for (int i = 0; i < paths.length; i++) {
            String ans = simplifyPath(paths[i]);
            String res = ans.equals(expected[i]) ? "PASS" : "FAIL";
            System.out.println(String.format(
                    "Test Case: %d | Input: %s | Output: %s | Expected: %s| Result: %s",
                    i + 1, paths[i], ans, expected[i], res
            ));
        }
    }
}
