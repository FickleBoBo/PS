import math
import sys

input = sys.stdin.readline

a, b = map(int, input().split())
c, d = map(int, input().split())

p = a * d + b * c
q = b * d
g = math.gcd(p, q)

print(p // g, q // g)
