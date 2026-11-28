import sys

input = sys.stdin.readline

r, c, n = map(int, input().split())
print(((r + n - 1) // n) * ((c + n - 1) // n))
