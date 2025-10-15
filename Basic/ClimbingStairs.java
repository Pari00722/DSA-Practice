public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;  
        int second = 2;  
        int third = 0;

        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 5;

        System.out.println("Input: n = " + n1 + " → Output: " + climbStairs(n1));
        System.out.println("Input: n = " + n2 + " → Output: " + climbStairs(n2));
        System.out.println("Input: n = " + n3 + " → Output: " + climbStairs(n3));
    }
}
