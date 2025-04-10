
public class LargestOddNumberInString {

    public static String largestOddNumber(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "35427";
        System.out.println(largestOddNumber(str));
    }
}
