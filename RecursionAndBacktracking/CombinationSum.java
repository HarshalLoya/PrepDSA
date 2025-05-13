
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // TC: O(K * L) (K is total number of combinations, L is avg length of curr) or O(2^T)
    // SC: O(K * L + T)
    public static void getCombinations(int index, int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if (candidates[index] <= target) {
            curr.add(candidates[index]);
            getCombinations(index, candidates, target - candidates[index], curr, ans);
            curr.remove(curr.size() - 1);
        }
        getCombinations(index + 1, candidates, target, curr, ans);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 8;

        List<List<Integer>> ans = combinationSum(candidates, target);
        System.out.println(ans);
        // for (List<Integer> combination : ans) {
        //     System.out.println(combination);
        // }
    }
}
