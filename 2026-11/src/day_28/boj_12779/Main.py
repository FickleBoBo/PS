import math
import sys

input = sys.stdin.readline

a, b = map(int, input().split())
cnt = math.isqrt(b) - math.isqrt(a)

if cnt == 0:
    print(0)
else:
    g = math.gcd(cnt, b - a)
    print(f"{cnt // g}/{(b - a) // g}")
