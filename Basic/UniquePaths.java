
import java.util.*;

public class UniquePaths {

    // Method to compute unique paths using combinatorics
    public static int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int movesDown = Math.min(m - 1, n - 1); 

        long ans = 1;

        for (int i = 1; i <= movesDown; i++) {
            ans = ans * (totalMoves - movesDown + i) / i;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter m: ");
        int m = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = uniquePaths(m, n);
        System.out.println("Unique Paths: " + result);

        sc.close();
    }
}
