import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
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
            boolean palindrome = true;
            String str = s.substring(index, i + 1);
            for (int j = 0; j < (str.length()/2); j++) {
                if (str.charAt(j) != str.charAt(str.length() - j - 1)) {
                    palindrome = false;
                    break;
                }
            }
            
            if (palindrome == true) {
                tempList.add(str);
                helper(s, i + 1, result, tempList);
                tempList.remove(tempList.size() - 1);   
            }
        }
    }
}