class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}

// in constant space without DP
// class Solution {
//     public int rob(int[] nums) {
//         int prevRobbed = 0;
//         int currentRobbed = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             int temp = prevRobbed;
//             prevRobbed = Math.max(prevRobbed, currentRobbed);
//             currentRobbed = temp + nums[i];
//         }
        
//         return Math.max(prevRobbed, currentRobbed);
//     }
// }