class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        cur = 0
        ans = -1_000_000_000
        for x in nums:
            cur = max(x, cur + x)
            ans = max(ans, cur)

        return ans
