def solve(money, l, r):
    prv2, prv1 = 0, 0

    for i in range(l, r):
        prv2, prv1 = prv1, max(prv1, prv2 + money[i])

    return prv1


def solution(money):
    n = len(money)

    case1 = solve(money, 0, n - 1)
    case2 = solve(money, 1, n)
    return max(case1, case2)
