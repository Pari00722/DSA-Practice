public class jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums)); // Output: 2
    }

    public static int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int end = 0;

        // no need to check last element (already reached)
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // if we reach the end of current jump range
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
}
