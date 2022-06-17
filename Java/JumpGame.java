class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}

// possible recursive solution
// class Solution {
   
//     public boolean canJump(int[] nums) {
//               return solve(0,nums); 
//     }
//     private boolean solve(int i, int[]nums){
        
//         if(i>=nums.length-1) return true;
//         int reachable=i+nums[i];
        
//         for(int k=i+1;k<=reachable;k++){
//                   if(solve(k,nums)){
//                 return true;
//             }      
//         }
//         return false;
//     }
// }