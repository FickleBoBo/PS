import sys

input = sys.stdin.readline

xs, ys = [], []
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    xs.append(x)
    ys.append(y)

print((max(xs) - min(xs)) * (max(ys) - min(ys)))
