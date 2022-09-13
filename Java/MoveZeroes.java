class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        int left = 0;
        int right = 1;
        while (right < length) {
            if (nums[left] != 0) {
                left++;
                right++;
            } else if (nums[right] == 0) {
                right++;
            } else if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
    }
}