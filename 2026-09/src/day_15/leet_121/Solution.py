class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        mn = prices[0]
        diff = 0
        for p in prices[1:]:
            diff = max(diff, p - mn)
            mn = min(mn, p)

        return diff
