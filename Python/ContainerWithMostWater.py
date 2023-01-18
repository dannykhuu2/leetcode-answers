class Solution:
    def maxArea(self, height: List[int]) -> int:
        largest = 0
        left = 0
        right = len(height) - 1

        while left < right:
            current = min(height[left], height[right]) * (right - left)
            if current > largest:
                largest = current
            if height[left] > height[right]:
                right -= 1
            else:
                left += 1
        return largest