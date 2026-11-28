import sys

input = sys.stdin.readline

arr = [1, 1, 2, 2, 2, 8]
print(*[x - cnt for x, cnt in zip(arr, map(int, input().split()))])
