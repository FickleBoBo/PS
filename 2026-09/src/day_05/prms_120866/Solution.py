def solution(board):
    n = len(board)
    vis = [[False] * n for _ in range(n)]

    for r in range(n):
        for c in range(n):
            if board[r][c]:
                vis[r][c] = True
                for dr, dc in ((-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)):
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < n and 0 <= nc < n:
                        vis[nr][nc] = True

    return sum(row.count(False) for row in vis)
