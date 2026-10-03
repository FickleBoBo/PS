def solution(money):
    n = len(money)

    def rob_range(l, r):
        dp = [0] * (1 + n)
        for i in range(l, r + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + money[i - 1])

        return dp[r]

    case1 = rob_range(1, n - 1)
    case2 = rob_range(2, n)
    return max(case1, case2)
