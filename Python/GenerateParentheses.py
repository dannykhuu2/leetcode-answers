class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self.helper(0, 0, result, "", n)
        return result

    def helper(self, left, right, result, current, n):
        if left + right == 2*n:
            result.append(current)
        if left < n:
            self.helper(left + 1, right, result, current + '(', n)
        if right < left:
            self.helper(left, right + 1, result, current + ')', n)