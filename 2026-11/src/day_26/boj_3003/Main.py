import sys

input = sys.stdin.readline

arr = [1, 1, 2, 2, 2, 8]
out = [n - x for n, x in zip(arr, map(int, input().split()))]
print(*out)
