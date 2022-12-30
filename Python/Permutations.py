class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.helper(nums, [], result)
        return result

    def helper(self, nums, temp, result):
        if len(temp) == len(nums):
            result.append(temp[:])
        for i in range(len(nums)):
            if nums[i] not in temp:
                temp.append(nums[i])
                self.helper(nums, temp, result)
                temp.pop()