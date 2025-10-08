public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.println("Unique Count: " + k1);
        System.out.print("Modified Array: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println("\n----------------------------");

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        System.out.println("Unique Count: " + k2);
        System.out.print("Modified Array: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }

        System.out.println("\n----------------------------");

        // Example 3 (Custom test)
        int[] nums3 = {-3, -3, -2, -1, -1, 0, 1, 1, 2};
        i
