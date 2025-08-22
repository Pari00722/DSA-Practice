public class factorial {
    public static long fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int num = 13;
        System.out.println("Factorial of " + num + " = " + fact(num));
    }
}

