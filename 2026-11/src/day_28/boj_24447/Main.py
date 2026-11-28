import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    q = deque([start])

    dist = [-1] * (1 + n)
    dist[start] = 0

    order = [0] * (1 + n)
    cnt = 1

    while q:
        cur = q.popleft()
        order[cur] = cnt
        cnt += 1

        for nxt in adj[cur]:
            if dist[nxt] != -1:
                continue
            dist[nxt] = dist[cur] + 1
            q.append(nxt)

    return sum(dist[i] * order[i] for i in range(1, n + 1))


n, m, r = map(int, input().split())
adj = [[] for _ in range(1 + n)]
for _ in range(m):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

for x in adj:
    x.sort()

print(bfs(r))
