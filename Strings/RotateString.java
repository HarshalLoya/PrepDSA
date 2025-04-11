
public class RotateString {

    // function to rotate the string by n shifts
    public static String rotateString(String str, int n) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        n = n % str.length();
        StringBuilder sb = new StringBuilder(str.substring(n, str.length()));
        sb.append(str.substring(0, n));
        return sb.toString();
    }

    // function to check if string b can be formed by rotating string a or not
    // TC: O(N), SC: O(N)
    public static boolean isRotational(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        String rotated = a + a;
        return rotated.contains(b);
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        int n = 2;
        System.out.println("Original String: " + str);
        System.out.println("Rotated String: " + rotateString(str, n));
        System.out.println("Is Rotational: " + isRotational("abcde", "cdeab"));
    }
}
