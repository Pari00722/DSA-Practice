
public class SqrtX {

    public static int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2;
        int ans = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid; // use long to avoid overflow

            if (sq == x) {
                return mid;
            } else if (sq < x) {
                ans = mid;    // mid is a valid sqrt, but try bigger
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));  // 2
        System.out.println(mySqrt(8));  // 2
        System.out.println(mySqrt(25)); // 5
        System.out.println(mySqrt(0));  // 0
    }
}
