from collections import deque


def solution(n, computers):
    vis = [False] * n

    def bfs(start):
        q = deque([start])
        vis[start] = True
        while q:
            cur = q.popleft()
            for nxt in range(n):
                if computers[cur][nxt] == 0 or vis[nxt]:
                    continue
                q.append(nxt)
                vis[nxt] = True

    cnt = 0
    for i in range(n):
        if vis[i]:
            continue
        bfs(i)
        cnt += 1

    return cnt
