import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
mx = max(arr)

total = 0
for x in arr:
    total += x / mx * 100

print(total / n)
