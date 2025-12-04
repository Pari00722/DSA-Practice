import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at same depth
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            curr.add(nums[i]);                // choose
            backtrack(nums, i + 1, curr, result); // explore
            curr.remove(curr.size() - 1);     // un-choose
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        System.out.println("Input: [1,2,2]");
        System.out.println("Output: " + subsetsWithDup(nums1));

        int[] nums2 = {0};
        System.out.println("Input: [0]");
        System.out.println("Output: " + subsetsWithDup(nums2));
    }
}
