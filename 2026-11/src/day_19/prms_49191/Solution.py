def solution(n, results):
    dp = [[False] * (1 + n) for _ in range(1 + n)]
    for u, v in results:
        dp[u][v] = True

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if dp[i][k] and dp[k][j]:
                    dp[i][j] = True

    ans = 0
    for i in range(1, n + 1):
        cnt = 0
        for j in range(1, n + 1):
            if dp[i][j] or dp[j][i]:
                cnt += 1

        if cnt == n - 1:
            ans += 1

    return ans
