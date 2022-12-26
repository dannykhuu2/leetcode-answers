class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        current = ""
        length = len(s)
        longest = 0

        for i in range(length):
            c = s[i]
            index = 0
            if c in current:
                index = current.index(c)
            else:
                index = -1
            if index != -1:
                current = current[index + 1:]
            current += c
            if len(current) > longest:
                longest = len(current)
        return longest