import sys

input = sys.stdin.readline

res = []


def dfs(cur):
    res.append(cur)
    for i in range(cur % 10):
        dfs(cur * 10 + i)


n = int(input())
for i in range(10):
    dfs(i)

if n >= len(res):
    print(-1)
else:
    res.sort()
    print(res[n])
