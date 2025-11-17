
import java.util.*;

/**
 * Solution for "Combination Sum II" where each candidate can be used at most once.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) continue;
            // early stopping because array is sorted
            if (nums[i] > remain) break;

            path.add(nums[i]);
            backtrack(nums, remain - nums[i], i + 1, path, res); // i+1: each number used at most once
            path.remove(path.size() - 1);
        }
    }

    // helper to print results for testing
    public static void main(String[] args) {
        CombinationSum2 solver = new CombinationSum2();

        int[] c1 = {10,1,2,7,6,1,5};
        int t1 = 8;
        List<List<Integer>> out1 = solver.combinationSum2(c1, t1);
        System.out.println("Example 1 results:");
        for (List<Integer> comb : out1) System.out.println(comb);

        int[] c2 = {2,5,2,1,2};
        int t2 = 5;
        List<List<Integer>> out2 = solver.combinationSum2(c2, t2);
        System.out.println("\nExample 2 results:");
        for (List<Integer> comb : out2) System.out.println(comb);
    }
}
