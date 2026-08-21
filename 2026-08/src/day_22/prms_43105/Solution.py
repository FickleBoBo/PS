def solution(triangle):
    n = len(triangle)
    dp = [[0] * (1 + n) for _ in range(1 + n)]

    for i in range(1, 1 + n):
        for j in range(1, 1 + i):
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1]

    return max(dp[n])
