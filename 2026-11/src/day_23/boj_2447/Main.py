import sys

input = sys.stdin.readline
out = []


def dfs(sr, sc, n):
    if n == 1:
        vis[sr][sc] = True
        return
    dfs(sr, sc, n // 3)
    dfs(sr, sc + n // 3, n // 3)
    dfs(sr, sc + n // 3 * 2, n // 3)
    dfs(sr + n // 3, sc, n // 3)
    dfs(sr + n // 3, sc + n // 3 * 2, n // 3)
    dfs(sr + n // 3 * 2, sc, n // 3)
    dfs(sr + n // 3 * 2, sc + n // 3, n // 3)
    dfs(sr + n // 3 * 2, sc + n // 3 * 2, n // 3)


n = int(input())

vis = [[False] * n for _ in range(n)]
dfs(0, 0, n)

for row in vis:
    out.append("".join("*" if x else " " for x in row))

print("\n".join(out))
