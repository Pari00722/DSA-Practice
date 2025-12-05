public class Decodenum{
    
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        
        int n = s.length();
        int prev = 1;  // dp[i-2]
        int curr = 1;  // dp[i-1]

        for (int i = 1; i < n; i++) {
            int temp = 0;

            // Check single digit decoding
            if (s.charAt(i) != '0') {
                temp = curr;
            }

            // Check two digit decoding
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += prev;
            }

            prev = curr;
            curr = temp;

            // If no valid decoding exists
            if (curr == 0)
                return 0;
        }
        
        return curr;
    }

    public static void main(String[] args) {
        String s1 = "12";
        String s2 = "226";
        String s3 = "06";
        String s4 = "11106";

        System.out.println("Input: " + s1 + " -> Output: " + numDecodings(s1));
        System.out.println("Input: " + s2 + " -> Output: " + numDecodings(s2));
        System.out.println("Input: " + s3 + " -> Output: " + numDecodings(s3));
        System.out.println("Input: " + s4 + " -> Output: " + numDecodings(s4));
    }
}

