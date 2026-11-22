import sys

input = sys.stdin.readline

input()
arr = sorted(map(int, input().split()))
x = int(input())

l, r = 0, len(arr) - 1
cnt = 0
while l < r:
    if arr[l] + arr[r] < x:
        l += 1
    elif arr[l] + arr[r] > x:
        r -= 1
    else:
        cnt += 1
        l += 1
        r -= 1

print(cnt)
