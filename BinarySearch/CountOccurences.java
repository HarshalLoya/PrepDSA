
public class CountOccurences {

    public static int countOccurrences(int[] array, int element) {
        int firstIndex = -1, lastIndex = -1;
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == element) {
                if (firstIndex == -1 || mid < firstIndex) {
                    firstIndex = mid;
                }
                if (lastIndex == -1 || mid > lastIndex) {
                    lastIndex = mid;
                }
                // Search in both directions
                int left = mid - 1, right = mid + 1;
                while (left >= low && array[left] == element) {
                    firstIndex = left;
                    left--;
                }
                while (right <= high && array[right] == element) {
                    lastIndex = right;
                    right++;
                }
                break;
            } else if (array[mid] < element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (firstIndex == -1 || lastIndex == -1) {
            return 0;  // Element is not present in the array
        }

        return lastIndex - firstIndex + 1;
    }

    // Finds the first and last index separately 
    // public static int countOccurrences(int[] array, int element) {
    //     int firstIndex = binarySearch(array, element, true);
    //     if (firstIndex == -1) {
    //         return 0; // Element is not present in the array
    //     }
    //     int lastIndex = binarySearch(array, element, false);
    //     return lastIndex - firstIndex + 1;
    // }
    // private static int binarySearch(int[] array, int element, boolean searchFirst) {
    //     int low = 0, high = array.length - 1, result = -1;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (array[mid] == element) {
    //             result = mid;
    //             if (searchFirst) {
    //                 high = mid - 1; // Search in the left half
    //             } else {
    //                 low = mid + 1; // Search in the right half
    //             }
    //         } else if (array[mid] < element) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return result;
    // }
    public static void main(String[] args) {
        int arr[] = {2, 3, 6, 8, 8, 8, 11, 13}, k = 8;
        System.out.println(countOccurrences(arr, k));
    }
}
