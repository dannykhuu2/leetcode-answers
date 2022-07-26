import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, result, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int index, List<List<String>> result, List<String> tempList) {
        if (index == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            
            if (isPalindrome(str)) {
                tempList.add(str);
                helper(s, i + 1, result, tempList);
                tempList.remove(tempList.size() - 1);   
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        for (int j = 0; j < (str.length()/2); j++) {
            if (str.charAt(j) != str.charAt(str.length() - j - 1)) {
                return false;
            }
        }
        return true;
    }
}