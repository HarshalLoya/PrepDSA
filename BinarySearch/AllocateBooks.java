
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class AllocateBooks {

    static boolean canAllocate(int[] books, int students, int maxPages) {
        int studentCount = 1, pagesAllocated = 0;
        for (int pages : books) {
            if (pagesAllocated + pages > maxPages) {
                studentCount++;
                pagesAllocated = pages;
                if (studentCount > students) {
                    return false;
                }
            } else {
                pagesAllocated += pages;
            }
        }
        return true;
    }

    // brute force approach, TC: O(N*(sum - max)), SC: O(1)
    // public static int allocateBooks(int[] books, int students) {
    //     int n = books.length;
    //     if (students > n) {
    //         return -1;
    //     }
    //     IntSummaryStatistics stats = Arrays.stream(books).summaryStatistics();
    //     int sum = (int) stats.getSum(), max = (int) stats.getMax();
    //     System.err.println(sum + " " + max);
    //     for (int i = max; i <= sum; i++) {
    //         if (canAllocate(books, students, i)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // optimized approach using binary search, TC: O(N*(log(sum - max))), SC: O(1)
    public static int allocateBooks(int[] books, int students) {
        int n = books.length;
        if (students > n) {
            return -1;
        }
        IntSummaryStatistics stats = Arrays.stream(books).summaryStatistics();
        int high = (int) stats.getSum(), low = (int) stats.getMax();
        while(low <= high) {
            int mid = low + (high - low) /2;
            if (canAllocate(books, students, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] books = {25, 46, 28, 49, 24};
        int students = 4; // Number of students to allocate books to
        int result = allocateBooks(books, students);
        System.out.println("Minimum number of pages: " + result);
    }
}
