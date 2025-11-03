public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Determine sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with positive numbers (convert to long to avoid overflow)
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        int result = 0;

        // Subtract divisor from dividend using bit shifting
        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            long multiple = 1;

            // Double divisor until it's just smaller than dividend
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract and accumulate quotient
            lDividend -= temp;
            result += multiple;
        }

        // Apply sign
        return negative ? -result : result;
    }

    // Test the function
    public static void main(String[] args) {
        System.out.println(divide(10, 3));   // Output: 3
        System.out.println(divide(7, -3));   // Output: -2
    }
}
