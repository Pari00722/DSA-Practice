public class Jumpgame{

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; 

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) return true; 
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Output: " + canJump(nums1)); // Expected: true

        // Example 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Output: " + canJump(nums2)); // Expected: false
    }
}
