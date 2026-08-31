def solve(money, l, r):
    n = len(money)
    dp = [0] * (1 + n)

    for i in range(l, r + 1):
        dp[i] = max(dp[i - 1], dp[i - 2] + money[i - 1])

    return dp[r]


def solution(money):
    n = len(money)

    case1 = solve(money, 1, n - 1)
    case2 = solve(money, 2, n)
    return max(case1, case2)
