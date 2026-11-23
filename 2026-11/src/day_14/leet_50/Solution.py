class Solution:
    def binpow(self, a, n):
        res = 1
        while n > 0:
            if n & 1:
                res *= a
            a *= a
            n >>= 1
        return res

    def myPow(self, x: float, n: int) -> float:
        if n >= 0:
            return self.binpow(x, n)
        else:
            return 1 / self.binpow(x, -n)
