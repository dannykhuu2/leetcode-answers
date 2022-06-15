class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        String current = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = current.indexOf(c);
            if (index != -1) {
                current = current.substring(index + 1);
            }
            current += c;
            if (current.length() > longest) {
                longest = current.length();
            }
        }
        return longest;
    }
}