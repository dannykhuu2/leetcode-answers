import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] chars = new boolean[s.length() + 1];
        chars[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i && chars[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    chars[i] = true;
                    break;
                }
            }
        }
        
        return chars[s.length()];
    }
}