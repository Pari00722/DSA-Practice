public class invstring {
    

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        // Quick length check
        if (n + m != k) return false;

        // dp[j] = can we form s3[0..i+j-1] using s1[0..i-1] and s2[0..j-1]
        boolean[] dp = new boolean[m + 1];

        // Initialize for i = 0 (using only s2)
        dp[0] = true;
        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }

        // Fill DP for i from 1..n
        for (int i = 1; i <= n; i++) {
            // First column (j = 0): using only s1
            dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));

            for (int j = 1; j <= m; j++) {
                char c3 = s3.charAt(i + j - 1);

                boolean fromS1 = dp[j] && (s1.charAt(i - 1) == c3);
                boolean fromS2 = dp[j - 1] && (s2.charAt(j - 1) == c3);

                dp[j] = fromS1 || fromS2;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("Example 1: " + isInterleave(s1, s2, s3)); // true

        // Example 2
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println("Example 2: " + isInterleave(s1, s2, s3)); // false

        // Example 3
        s1 = "";
        s2 = "";
        s3 = "";
        System.out.println("Example 3: " + isInterleave(s1, s2, s3)); // true

        // Custom Example
        s1 = "abc";
        s2 = "def";
        s3 = "adbcef";
        System.out.println("Custom: " + isInterleave(s1, s2, s3)); // true
    }
}
