import sys

input = sys.stdin.readline
out = []


def dfs(sr, sc, n):
    if n == 3:
        vis[sr][sc + 2] = True
        vis[sr + 1][sc + 1] = True
        vis[sr + 1][sc + 3] = True
        vis[sr + 2][sc] = True
        vis[sr + 2][sc + 1] = True
        vis[sr + 2][sc + 2] = True
        vis[sr + 2][sc + 3] = True
        vis[sr + 2][sc + 4] = True
        return
    dfs(sr, sc + n // 2, n // 2)
    dfs(sr + n // 2, sc, n // 2)
    dfs(sr + n // 2, sc + n, n // 2)


n = int(input())

vis = [[False] * (n * 2) for _ in range(n)]
dfs(0, 0, n)

for row in vis:
    out.append("".join("*" if x else " " for x in row))

print("\n".join(out))
