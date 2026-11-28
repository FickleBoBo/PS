import sys

input = sys.stdin.readline

vis = [False] * (1 + 30)
for _ in range(28):
    x = int(input())
    vis[x] = True

for i in range(1, 31):
    if vis[i]:
        continue
    print(i)
