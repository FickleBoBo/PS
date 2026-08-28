import math


def sieve(n):
    is_prime = [True] * (1 + n)
    is_prime[0] = is_prime[1] = False

    for i in range(2, math.isqrt(n) + 1):
        if is_prime[i]:
            is_prime[i * i :: i] = [False] * len(range(i * i, n + 1, i))

    return is_prime


def solution(n):
    is_prime = sieve(n)
    return sum(1 for i in range(2, n + 1) if not is_prime[i])
