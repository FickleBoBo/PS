import sys

input = sys.stdin.readline

n, m = map(int, input().split())
print(min(n, m) // 2)
