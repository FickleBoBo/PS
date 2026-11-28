import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    q = deque([start])

    vis = [False] * (1 + n)
    vis[start] = True

    order = [0] * (1 + n)
    cnt = 1

    while q:
        cur = q.popleft()
        order[cur] = cnt
        cnt += 1

        for nxt in adj[cur]:
            if vis[nxt]:
                continue
            vis[nxt] = True
            q.append(nxt)

    return order


n, m, r = map(int, input().split())
adj = [[] for _ in range(1 + n)]
for _ in range(m):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

for x in adj:
    x.sort(reverse=True)

print("\n".join(map(str, bfs(r)[1:])))
