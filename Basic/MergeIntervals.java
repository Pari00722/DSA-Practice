
import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int curStart = intervals[0][0], curEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s <= curEnd) {                    // overlap (including touching)
                curEnd = Math.max(curEnd, e);
            } else {
                res.add(new int[]{curStart, curEnd});
                curStart = s; curEnd = e;
            }
        }
        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] in1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] out1 = merge(in1);
        System.out.println(Arrays.deepToString(out1)); // [[1,6],[8,10],[15,18]]

        int[][] in2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(merge(in2))); // [[1,5]]

        int[][] in3 = {{4,7},{1,4}};
        System.out.println(Arrays.deepToString(merge(in3))); // [[1,7]]
    }
}
