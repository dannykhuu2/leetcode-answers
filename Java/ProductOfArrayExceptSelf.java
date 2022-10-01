public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int right = 1;

        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        for (int j = length - 1; j >= 0; j--) {
            result[j] = result[j] * right;
            right *= nums[j];
        }
        return result;
    }
}