import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        result.add(intervals[0]);
        
        for (int[] interval: intervals) {
            int[] tempInterval = result.get(result.size() - 1);
            if (interval[0] <= tempInterval[1]) {
                int[] temp = new int[] {tempInterval[0], Math.max(tempInterval[1], interval[1])};
                result.set(result.size() - 1, temp);
            } else {
                result.add(interval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}