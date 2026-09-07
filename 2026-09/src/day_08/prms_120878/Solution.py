import math


def solution(a, b):
    q = b // math.gcd(a, b)
    while q % 2 == 0:
        q //= 2
    while q % 5 == 0:
        q //= 5

    return 1 if q == 1 else 2
