import sys

input = sys.stdin.readline

arr = list(range(1, 21))
for _ in range(10):
    s, e = map(int, input().split())
    arr[s - 1 : e] = arr[s - 1 : e][::-1]

print(*arr)
