class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int mid = 0;
        
        for (int i = 0; i < length; i++) {
            mid = i;
            if (nums[i] > 0) {
                break;
            }
        }
        
        int left = mid - 1;
        int right = mid;
        int[] result = new int[length];
        int index = 0;
        while (left >= 0 && right < length) {
            if (Math.abs(nums[left]) > nums[right]) {
                result[index] = nums[right] * nums[right];
                right++;
            } else {
                result[index] = nums[left] * nums[left];
                left--;
            }
            index++;
        }
        
        while (left >= 0) {
            result[index++] = nums[left] * nums[left];
            left--;
        }
        
        while (right < length) {
            result[index++] = nums[right] * nums[right];
            right++;
        }
        
        return result;
    }
}