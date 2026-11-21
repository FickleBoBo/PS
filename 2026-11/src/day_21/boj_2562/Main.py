import sys

input = sys.stdin.readline

arr = [int(input()) for _ in range(9)]
mx = max(arr)
print(mx)
print(arr.index(mx) + 1)
