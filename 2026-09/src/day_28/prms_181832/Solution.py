def solution(n):
    arr = [[0] * n for _ in range(n)]
    dr = (-1, 0, 1, 0)
    dc = (0, 1, 0, -1)
    r, c, d, num = 0, -1, 1, 1

    while num <= n * n:
        nr, nc = r + dr[d], c + dc[d]
        if not (0 <= nr < n and 0 <= nc < n) or arr[nr][nc] != 0:
            d = (d + 1) % 4
            nr, nc = r + dr[d], c + dc[d]

        arr[nr][nc] = num
        num += 1
        r, c = nr, nc

    return arr
