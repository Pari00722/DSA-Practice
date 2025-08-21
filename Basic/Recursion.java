public class recursion{
    // Recursive function
    static void printNTimes(int n) {
        // Base case
        if (n == 0) {
            return;
        }

        // Recursive step
        printNTimes(n - 1); // call for smaller problem
        System.out.println("Hello " + n); // print after recursion
    }

    public static void main(String[] args) {
        int n = 5; // You can change this
        printNTimes(n);
    }
}
