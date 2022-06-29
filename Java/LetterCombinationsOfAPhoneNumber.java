import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" ,"wxyz"};
        LinkedList<String> combinations = new LinkedList<>();
        
        if (digits.length() == 0) return combinations;
        combinations.add("");
            
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (combinations.peek().length() == i) {
                String current = combinations.poll();
                for (int j = 0; j < letters[index].length(); j++) {
                    combinations.add(current + letters[index].charAt(j));
                }
            }
        }
        
        return combinations;
    }
}