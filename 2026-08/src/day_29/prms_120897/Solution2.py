import math


def solution(n):
    seen = set()

    for i in range(1, math.isqrt(n) + 1):
        if n % i == 0:
            seen.add(i)
            seen.add(n // i)

    return sorted(seen)
