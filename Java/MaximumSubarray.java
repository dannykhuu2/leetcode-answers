// O(n) solution
class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int latestMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            latestMax = Math.max(latestMax + nums[i], nums[i]);
            currentMax = Math.max(latestMax, currentMax);
        }
        
        return currentMax;
    }
}

// initial attempt: works for 204/209 test cases but fails tests with large inputs, longer than O(n)
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = nums[0];
//         int current = nums[0];
//         int start = 0;
//         int end = 1;
        
//         for (int i = 1; i < nums.length; i++) {
//             current += nums[i];
//             if (current > max) {
//                 max = current;
//             }
//             end = i;
//             int tempCurrent = current;
//             int index = start;

//             while (index < end) {
//                 tempCurrent -= nums[index];
//                 if (tempCurrent > max) {
//                     max = tempCurrent;
//                     current = tempCurrent;
//                     start = index + 1;
//                 }
//                 index++;
//             }
//         }
//         return max;
//     }
// }