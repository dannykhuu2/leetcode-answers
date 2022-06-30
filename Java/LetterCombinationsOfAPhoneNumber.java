import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" ,"wxyz"};
        List<String> combinations = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        if (digits.length() == 0) return combinations;
        letterCombinationsHelper(digits, letters, combinations, current);
        return combinations;
    }
    
    private void letterCombinationsHelper(String digits, String[] letters, List<String> combinations, StringBuilder current) {
        if (current.length() == digits.length()) {
            if (current.length() != 0) combinations.add(current.toString());
            return;
        }
        
        int indexLetter = Character.getNumericValue(digits.charAt(current.length()));
        for (int i = 0; i < letters[indexLetter].length(); i++) {
            current.append(letters[indexLetter].charAt(i));
            letterCombinationsHelper(digits, letters, combinations, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

// class Solution {
//     public List<String> letterCombinations(String digits) {
//         String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" ,"wxyz"};
//         LinkedList<String> combinations = new LinkedList<>();
        
//         if (digits.length() == 0) return combinations;
//         combinations.add("");
            
//         for (int i = 0; i < digits.length(); i++) {
//             int index = Character.getNumericValue(digits.charAt(i));
//             while (combinations.peek().length() == i) {
//                 String current = combinations.poll();
//                 for (int j = 0; j < letters[index].length(); j++) {
//                     combinations.add(current + letters[index].charAt(j));
//                 }
//             }
//         }
        
//         return combinations;
//     }
// }