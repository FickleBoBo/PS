import sys

input = sys.stdin.readline

sys.setrecursionlimit(10**6)


def dfs(cur):
    global cnt
    vis[cur] = True
    order[cur] = cnt
    cnt += 1

    for nxt in adj[cur]:
        if not vis[nxt]:
            dfs(nxt)


n, m, r = map(int, input().split())
adj = [[] for _ in range(1 + n)]
for _ in range(m):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

for x in adj:
    x.sort(reverse=True)

vis = [False] * (1 + n)
order = [0] * (1 + n)
cnt = 1

dfs(r)

print("\n".join(map(str, order[1:])))
