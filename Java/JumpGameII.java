class Solution {
    public int jump(int[] nums) {
        int lastIndex = nums.length - 1;
        int amount = 0;
        while (lastIndex > 0) {
            int index = lastIndex;
            for (int i = lastIndex - 1; i >= 0; i--) {
                int value = i + nums[i];
                if (value >= lastIndex) {
                    index = i;
                }
            }
            lastIndex = index;
            amount++;       
        }
        return amount;
    }
}