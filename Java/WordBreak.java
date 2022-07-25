import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] chars = new boolean[s.length() + 1];
        
        chars[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String str: wordDict) { 
                if (str.length() <= i && chars[i - str.length()] && s.substring(i-str.length(), i).equals(str)) {
                    chars[i] = true;
                    break;
                }
            }
        }
        
        return chars[s.length()];
    }
}