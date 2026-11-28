import sys

input = sys.stdin.readline

n, m = map(int, input().split())

arr = [0] * n
for _ in range(m):
    s, e, x = map(int, input().split())
    arr[s - 1 : e] = [x] * (e - s + 1)

print(*arr)
