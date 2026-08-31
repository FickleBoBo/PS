import sys

sys.setrecursionlimit(10**6)


def solution(n, computers):
    vis = [False] * n

    def dfs(cur):
        vis[cur] = True
        for nxt in range(n):
            if computers[cur][nxt] == 0 or vis[nxt]:
                continue
            dfs(nxt)

    cnt = 0
    for i in range(n):
        if vis[i]:
            continue
        dfs(i)
        cnt += 1

    return cnt
