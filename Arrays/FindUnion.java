
import java.util.ArrayList;
import java.util.HashMap;

public class FindUnion {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr2[] = {2, 3, 4, 4, 5, 11, 12};
        int n = arr1.length, m = arr2.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        // hashmap approach
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            list.add(i);
        }
        System.out.println(list);

        // hashset approach
        // HashSet<Integer> hs = new HashSet<>();
        // for (int i : arr1) {
        //     hs.add(i);
        // }
        // for (int i : arr2) {
        //     hs.add(i);
        // }
        // for (int i : hs) {
        //     list.add(i);
        // }
        // System.out.println(list);

        // two pointer approach
        // int i = 0, j = 0;
        // while (i < n && j < m) {
        //     if (arr1[i] <= arr2[j]) {
        //         if (list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
        //             list.add(arr1[i]);
        //         }
        //         i++;
        //     } else {
        //         if (list.isEmpty() || list.get(list.size() - 1) != arr2[j]) {
        //             list.add(arr2[j]);
        //         }
        //         j++;
        //     }
        // }
        // while (i < n) {
        //     if (list.get(list.size() - 1) != arr1[i]) {
        //         list.add(arr1[i]);
        //     }
        //     i++;
        // }
        // while (j < m) {
        //     if (list.get(list.size() - 1) != arr2[j]) {
        //         list.add(arr2[j]);
        //     }
        //     j++;
        // }
        // System.out.println(list);
    }
}
