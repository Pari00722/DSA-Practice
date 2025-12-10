
import java.util.*;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1. Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);  // add the merged interval

        // 3. Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List to 2D array
        return result.toArray(new int[result.size()][]);
    }

    // ---------------- Main Method -----------------
    public static void main(String[] args) {

        int[][] intervals1 = { {1, 3}, {6, 9} };
        int[] newInterval1 = {2, 5};

        int[][] ans1 = insert(intervals1, newInterval1);
        System.out.println("Output 1:");
        for (int[] a : ans1) {
            System.out.println(Arrays.toString(a));
        }

        int[][] intervals2 = { {1,2}, {3,5}, {6,7}, {8,10}, {12,16} };
        int[] newInterval2 = {4, 8};

        int[][] ans2 = insert(intervals2, newInterval2);
        System.out.println("\nOutput 2:");
        for (int[] a : ans2) {
            System.out.println(Arrays.toString(a));
        }
    }
}
