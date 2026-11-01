class Solution:
    def isHappy(self, n: int) -> bool:

        def step(x):
            return sum(int(d) ** 2 for d in str(x))

        slow, fast = n, step(n)
        while slow != fast:
            slow = step(slow)
            fast = step(step(fast))

        return slow == 1
