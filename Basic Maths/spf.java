public class spf {
    public static int smallestPrimeFactor(int n) {
        if (n <= 1) return -1; // no prime factors for 0 or 1

        // check for smallest divisor
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return i; // first divisor is the SPF
        }

        return n; // if no divisor found, n itself is prime
    }

    public static void main(String[] args) {
        int n = 91;
        System.out.println("Smallest Prime Factor of " + n + " is: " + smallestPrimeFactor(n));
    }
}

