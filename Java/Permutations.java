import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<Integer>(), nums);
        return list;
    }
    
    private void permuteHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                 if (!tempList.contains(nums[i])) {
                     tempList.add(nums[i]);
                     permuteHelper(list, tempList, nums);
                     tempList.remove(tempList.size() - 1);
                 }
            }
        }
    }
}