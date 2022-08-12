import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        String result = "";
        
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsStr, (String str1, String str2) -> {
            return (str2+str1).compareTo(str1+str2);
        });
        
        
        for (String str : numsStr) {
            result += str;
        }
        
        if (result.equals("0".repeat(result.length()))) {
            return "0";
        }
        
        return result;
    }
}