class Solution:
    def countBits(self, n: int) -> list[int]:
        ans = [0] * (1 + n)
        for i in range(1, n + 1):
            ans[i] = ans[i & (i - 1)] + 1

        return ans
