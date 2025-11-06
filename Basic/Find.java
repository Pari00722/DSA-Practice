
import java.util.*;

public class Find {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] ans = searchRange(nums, target);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{
            findBound(nums, target, true),
            findBound(nums, target, false)
        };
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int lo = 0, hi = nums.length - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                ans = mid;
                // if searching for first occurrence -> go left
                if (isFirst) hi = mid - 1;
                else lo = mid + 1; // searching last -> go right
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}
