class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longest = 0;
        int counter = 0;
        
        for (int num : nums) {
            if (num == 1) {
                counter++;
            } else {
                counter = 0;
            }
            longest = Math.max(longest, counter);
        }
        return longest;
    }
}