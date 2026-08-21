def func(money, start, end):
    n = len(money)
    dp = [0] * (1 + n)

    for i in range(start, end + 1):
        dp[i] = max(dp[i - 1], dp[i - 2] + money[i - 1])

    return dp[end]


def solution(money):
    n = len(money)

    case1 = func(money, 1, n - 1)
    case2 = func(money, 2, n)
    return max(case1, case2)
