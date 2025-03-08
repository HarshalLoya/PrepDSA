
class LongestSubarrayWithSumK {

    // Brute force but can be more brute forced if sum is calculated using a loop inside the 2nd for loop
    // public static int[] findlongestarray(int[] arr, long k){
    //     int longest = 0, start = 0, end = 0;
    //     for(int i = 0; i < arr.length; i++){
    //         int sum = 0;
    //         for(int j = i; j < arr.length; j++){
    //             sum += arr[j];
    //             if(sum == k){
    //                 if(longest < j - i + 1) {
    //                     longest = j - i + 1;
    //                     start = i;
    //                     end = j;
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    //     return new int[]{longest, start, end};
    // }

    // Optimal if there are no negative numbers
    // public static int findlongestarray(int[] arr, long k) {
    //     int n = arr.length, maxlen = 0;
    //     long sum = 0;
    //     Map<Long, Integer> mpp = new HashMap<>();
    //     for(int i = 0; i < n; i++){
    //         sum += arr[i];
    //         if(sum == k){
    //             maxlen = Math.max(maxlen, i + 1);
    //         }
    //         long rem = sum - k;
    //         if(mpp.containsKey(rem)){
    //             int len = i - mpp.get(rem);
    //             maxlen = Math.max(maxlen, len);
    //         }
    //         if(!mpp.containsKey(sum)){
    //             mpp.put(sum, i);
    //         }
    //     }
    //     return maxlen;
    // }

    public static int findlongestarray(int[] arr, long k) {
        int n = arr.length, maxlen = 0, sum = arr[0], start = 0, end = 0;
        while (end < n) {
            while (start <= end && sum > k) {
                sum -= arr[start];
                start++;
            }
            if (sum == k) {
                maxlen = Math.max(maxlen, end - start + 1);
            }
            end++;
            if (end < n) {
                sum += arr[end];
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 0, 5, 1, 9, -5, 0, 0, 0,5};
        long k = 10;
        // Brute force
        // System.out.println(Arrays.toString(findlongestarray(arr, k)));
        System.out.println("Length of longest subarray: " + findlongestarray(arr, k));
    }
}
