
public class IsomorphicStrings {

    // TC: O(N), SC: O(1), even tho we use two extra arrays, they are of fixed size, hence constant SC
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] smap = new int[128];
        int[] tmap = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (smap[cs] != tmap[ct]) {
                return false;
            }
            smap[cs] = i + 1;
            tmap[ct] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba")); // true
    }
}
