public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int left = 1;
        int right = 1;

        for (int i = 0; i < length; i++) {
            result[i] = left;
            left *= nums[i];
        }
        
        for (int j = length - 1; j >= 0; j--) {
            result[j] = result[j] * right;
            right *= nums[j];
        }
        return result;
    }
}