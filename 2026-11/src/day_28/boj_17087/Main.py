import math
import sys

input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

g = 0
for x in arr:
    g = math.gcd(g, abs(s - x))

print(g)
