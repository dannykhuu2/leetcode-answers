import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int longestSeq = 0;
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int seq = 1;
                
                while (set.contains(current + 1)) {
                    current++;
                    seq++;
                }
                
                longestSeq = Math.max(longestSeq, seq);
            }
        }
        
        return longestSeq;
    }
}