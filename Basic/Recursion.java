public class recursion{
    static void printNTimes(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        printNTimes(n - 1); 
        System.out.println("Hello " + n); 
    }

    public static void main(String[] args) {
        int n = 9;
        printNTimes(n);
    }
}
