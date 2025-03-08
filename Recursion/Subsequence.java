
import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    private static void solve(int[] arr, int index, List<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }
        // pick the element at the current index
        list.add(arr[index]);
        solve(arr, index + 1, list);
        // do not pick the element at the current index
        list.remove(list.size() - 1);
        solve(arr, index + 1, list);
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2}, index = 0;
        List<Integer> list = new ArrayList<>();
        solve(arr, index, list);
    }
}
