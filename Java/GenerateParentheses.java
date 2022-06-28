import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateHelper(n, result, "", 0, 0);
        return result;
    }
    
    private void generateHelper(int n, List<String> result, String current, int left, int right) {
        if (current.length() == 2*n) {
            result.add(current);
            return;
        }
        
        if (left < n) {
            generateHelper(n, result, current + '(', left + 1, right);
        }
        if (right < left) {
            generateHelper(n, result, current + ')', left, right + 1);
        }
        
    }
}