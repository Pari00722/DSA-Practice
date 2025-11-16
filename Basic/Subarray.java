public class Subarray {
    
    public int maxSubArray(int[] nums) {
        // handle small arrays implicitly
        int curr = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]); // either start new at nums[i] or extend
            best = Math.max(best, curr);
        }
        return best;
    }

    // quick main to test the examples
    public static void main(String[] args) {
        Subarray s = new Subarray();
        System.out.println(s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(s.maxSubArray(new int[]{1}));                     // 1
        System.out.println(s.maxSubArray(new int[]{5,4,-1,7,8}));           // 23
    }
}
