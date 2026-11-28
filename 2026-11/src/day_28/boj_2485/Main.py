import math
import sys

input = sys.stdin.readline

n = int(input())
arr = [int(input()) for _ in range(n)]

g = arr[1] - arr[0]
for i in range(2, n):
    g = math.gcd(g, arr[i] - arr[i - 1])

print((arr[n - 1] - arr[0]) // g + 1 - n)
