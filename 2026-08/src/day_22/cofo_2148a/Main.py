import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    x, n = map(int, input().split())

    if n % 2:
        print(x)
    else:
        print(0)
