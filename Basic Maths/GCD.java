public class GCD {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 197, b = 78;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}
