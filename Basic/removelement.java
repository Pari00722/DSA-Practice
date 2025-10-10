public class removelement {
    public static int removeElement(int[] nums, int val) {
        int k = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int k = removeElement(nums, val);
        System.out.println("k = " + k);

        System.out.print("nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i < k)
                System.out.print(nums[i] + (i == k - 1 ? "" : ", "));
            else
                System.out.print("_" + (i == nums.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}
