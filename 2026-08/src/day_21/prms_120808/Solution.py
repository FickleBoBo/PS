import math


def solution(numer1, denom1, numer2, denom2):
    p = numer1 * denom2 + numer2 * denom1
    q = denom1 * denom2
    d = math.gcd(p, q)
    return [p // d, q // d]
