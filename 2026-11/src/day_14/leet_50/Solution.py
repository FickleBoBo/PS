class Solution:
    def bin_pow(self, a, n):
        res = 1
        while n > 0:
            if n & 1:
                res *= a
            a *= a
            n >>= 1
        return res

    def myPow(self, x: float, n: int) -> float:
        if n >= 0:
            return self.bin_pow(x, n)
        else:
            return 1 / self.bin_pow(x, -n)
