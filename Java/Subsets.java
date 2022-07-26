import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (int i = 0; i < nums.length; i++) {
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> tempList = new ArrayList<>(result.get(j));
                tempList.add(nums[i]);
                result.add(tempList);
            }
        }
        
        return result;
    }
}