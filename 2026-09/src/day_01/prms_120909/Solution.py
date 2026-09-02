import math


def solution(n):
    r = math.isqrt(n)
    return 1 if r * r == n else 2
