
import java.util.Scanner;


public class Palindrome {

    public static boolean check(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a string: ");
            String input = sc.nextLine();
            System.out.println(check(input));
        }
    }
}

// recursive code
// static boolean palindrome(int i, String s){
//     // Base Condition
//     // If i exceeds half of the string, means all the elements 
//     // are compared, we return true.
//     if(i>=s.length()/2) return true;
//     // If start is not equal to end, not palindrome.
//     if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
//     // If both characters are same, increment i and check start+1 and end-1.
//     return palindrome(i+1,s);
// }

// better code to handle wierd strings too
// public boolean isPalindrome(String s) {
//     String clean = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//     int left = 0, right = clean.length() - 1;
//     while(left < right){
//         if(clean.charAt(left) != clean.charAt(right)) return false;
//         else {
//             left++;
//             right--;
//             }
//     }
//     return true;
// }
