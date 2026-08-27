import math


def solution(n):
    return max(i for i in range(1, 11) if math.factorial(i) <= n)
