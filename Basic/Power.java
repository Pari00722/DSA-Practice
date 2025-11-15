public class Power{
    public double myPow(double x, int n) {
        long N = n; // convert to long to avoid overflow when n = -2^31

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {
            if ((N & 1) == 1) {  // if N is odd
                result *= x;
            }
            x *= x;      // square the base
            N >>= 1;     // divide exponent by 2
        }

        return result;
    }
}
