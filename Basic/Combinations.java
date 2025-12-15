
import java.util.*;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k,
                                  List<Integer> temp,
                                  List<List<Integer>> result) {
        // If combination size is k, add to result
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try all possible next numbers
        for (int i = start; i <= n; i++) {
            temp.add(i);                // choose
            backtrack(i + 1, n, k, temp, result); // explore
            temp.remove(temp.size() - 1); // un-choose
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<List<Integer>> combinations = combine(n, k);
        System.out.println(combinations);
    }
}
