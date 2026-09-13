class Solution:
    def missingNumber(self, nums: list[int]) -> int:
        ans = 0
        for i in range(1, len(nums) + 1):
            ans ^= i
        for x in nums:
            ans ^= x

        return ans
