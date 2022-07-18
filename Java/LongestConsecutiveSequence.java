import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 0;
        int maxCount = 0;
        int prev = 0;
        TreeMap<Integer, Integer> positions = new TreeMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            positions.put(nums[i], i);
        }
        
        for (Map.Entry<Integer, Integer> entry: positions.entrySet()) {
            if (entry.getKey() == prev + 1) {
                count++;
                prev = entry.getKey();
            } else {
                count = 1;
                prev = entry.getKey();
            }
            
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}