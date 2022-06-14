class Solution {
    public String longestPalindrome(String s) {
        
        if (s.length() == 0 || s == null) {
            return "";
        }
        
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            int longestEven = middleOut(s, i, i + 1);
            int longestOdd = middleOut(s, i, i);
            int longestValue = Math.max(longestEven, longestOdd);
            
            String substring = s.substring(i - (longestValue - 1)/2, i + longestValue/2 + 1);
            
            if (substring.length() > result.length()) {
                result = substring;
            }
        }
        return result;
    }
    
    private int middleOut(String s, int index1, int index2) {
        int left = index1;
        int right = index2;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}