class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n not in seen:
            seen.add(n)
            n = sum(int(d) ** 2 for d in str(n))

        return n == 1
