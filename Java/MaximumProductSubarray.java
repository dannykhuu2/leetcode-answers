class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int prevMax = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(prevMax * nums[i], Math.min(min * nums[i], nums[i]));
            result = max > result ? max : result;
        }
        return result;
    }
}