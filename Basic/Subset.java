
import java.util.*;

class Subset{

    public static List<List<Integer>> subsets(int[] nums) {
        // DECLARE result here
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int index, int[] nums,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    // MAIN CLASS
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }
}
