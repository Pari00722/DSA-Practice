public class UniqueBST {

    // Function to compute number of unique BSTs
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // Empty tree
        dp[1] = 1;  // Single node

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        return dp[n];
    }

    // Main method
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 1;

        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + numTrees(n1));  // 5

        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + numTrees(n2));  // 1
    }
}
