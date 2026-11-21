import sys

input = sys.stdin.readline

a, b = sorted(map(int, input().split()))
print(max(b - a - 1, 0))
print(*range(a + 1, b))
