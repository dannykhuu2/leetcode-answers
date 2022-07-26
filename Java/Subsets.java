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

    // private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
    //     result.add(new ArrayList<>(tempList));
    //     for (int i = start; i < nums.length; i++) {
    //         tempList.add(nums[i]);
    //         backtrack(nums, result, tempList, i + 1);
    //         tempList.remove(tempList.size() - 1);
    //     }
                   
    // }
}