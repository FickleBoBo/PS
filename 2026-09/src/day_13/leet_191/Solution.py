class Solution:
    def hammingWeight(self, n: int) -> int:
        cnt = 0
        while n:
            if n & 1:
                cnt += 1
            n >>= 1

        return cnt
