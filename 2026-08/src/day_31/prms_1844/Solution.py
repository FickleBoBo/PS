from collections import deque


def solution(maps):
    n, m = len(maps), len(maps[0])
    dist = [[0] * m for _ in range(n)]

    q = deque([(0, 0)])
    dist[0][0] = 1

    while q:
        r, c = q.popleft()
        if (r, c) == (n - 1, m - 1):
            return dist[r][c]

        for dr, dc in ((-1, 0), (0, 1), (1, 0), (0, -1)):
            nr, nc = r + dr, c + dc

            if not (0 <= nr < n and 0 <= nc < m):
                continue
            if maps[nr][nc] == 0 or dist[nr][nc] != 0:
                continue

            q.append((nr, nc))
            dist[nr][nc] = dist[r][c] + 1

    return -1
