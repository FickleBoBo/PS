MOD = 1_000_000_007


def solution(m, n, puddles):
    chk = [[False] * (1 + m) for _ in range(1 + n)]
    for x, y in puddles:
        chk[y][x] = True

    dp = [[0] * (1 + m) for _ in range(1 + n)]
    dp[0][1] = 1

    for i in range(1, 1 + n):
        for j in range(1, 1 + m):
            if chk[i][j]:
                continue
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD

    return dp[n][m]
