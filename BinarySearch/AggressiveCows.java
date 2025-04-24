
import java.util.Arrays;

public class AggressiveCows {

    static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int count = 1, lastPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i];
                if (count == cows) {
                    return true;
                }
            }
        }
        return false;
    }

    // brute force solution, TC: O(NlogN) + O(N*(max - min)), SC: O(1)
    // static int placeCows(int[] stalls, int cows) {
    //     int min = 1, max = stalls[stalls.length - 1] - stalls[0];
    //     for(int i = min; i <= max; i++) {
    //         if (canPlaceCows(stalls, cows, i) == false) {
    //             return i - 1;
    //         }
    //     }
    //     return max;
    // }

    // optimized solution, TC: O(NlogN) + O(N*(log(max - min))), SC: O(1)
    static int placeCows(int[] stalls, int cows) {
        int min = 1, max = stalls[stalls.length - 1] - stalls[0];
        int result = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid;
                min = mid + 1; // try for a larger minimum distance
            } else {
                max = mid - 1; // try for a smaller minimum distance
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int stalls[] = {0, 3, 4, 7, 10, 9}, cows = 4;
        Arrays.sort(stalls);
        int result = placeCows(stalls, cows);
        System.out.println(result);
    }
}
