import sys

input = sys.stdin.readline

vis = [False] * (1 + 30)
for _ in range(28):
    n = int(input())
    vis[n] = True

for i in range(1, 30 + 1):
    if vis[i]:
        continue
    print(i)
