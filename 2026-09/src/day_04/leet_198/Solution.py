class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [0] * (1 + n)

        for i in range(1, n + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1])

        return dp[n]
