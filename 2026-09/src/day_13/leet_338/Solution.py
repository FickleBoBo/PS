class Solution:
    def countBits(self, n: int) -> list[int]:
        ans = [0] * (1 + n)
        for i in range(1, n + 1):
            x = i
            cnt = 0
            while x:
                if x & 1:
                    cnt += 1
                x >>= 1
            ans[i] = cnt

        return ans
