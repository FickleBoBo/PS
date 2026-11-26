import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(range(1, n + 1))

for _ in range(m):
    s, e = map(int, input().split())
    arr[s - 1 : e] = arr[s - 1 : e][::-1]

print(*arr)
