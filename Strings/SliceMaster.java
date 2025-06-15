
import java.util.ArrayList;
import java.util.List;

public class SliceMaster {

    public static int minPointsWithParts(String s, List<String> parts) {
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int score = 0, start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                int len = end - start + 1;
                parts.add(s.substring(start, end + 1));
                score += len * len;
                start = i + 1;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        String[] testInputs = {
            "abac",
            "aaaa",
            "abc",
            "abaccbdeffed",
            "a",
            "abacdecfeg"
        };

        int[] expectedScores = {10, 16, 3, 72, 1, 46};

        for (int i = 0; i < testInputs.length; i++) {
            String s = testInputs[i];

            List<String> parts = new ArrayList<>();
            int actualScore = minPointsWithParts(s, parts);

            String result = actualScore == expectedScores[i] ? "PASS" : "FAIL";
            System.out.println(String.format(
                    "Test %d | Input: \"%s\" | Expected: %d | Actual: %d | Partitions: %s | Result: %s",
                    i + 1, s, expectedScores[i], actualScore, parts, result
            ));
        }
    }

}
