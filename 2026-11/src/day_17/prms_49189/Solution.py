from collections import deque


def solution(n, edge):
    adj = [[] for _ in range(1 + n)]
    for u, v in edge:
        adj[u].append(v)
        adj[v].append(u)

    q = deque([1])

    vis = [False] * (1 + n)
    vis[1] = True

    ans = 0
    while q:
        ans = len(q)
        for _ in range(len(q)):
            cur = q.popleft()
            for nxt in adj[cur]:
                if vis[nxt]:
                    continue
                q.append(nxt)
                vis[nxt] = True

    return ans
