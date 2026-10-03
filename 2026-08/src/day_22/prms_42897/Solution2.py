def solution(money):
    n = len(money)

    def rob_range(l, r):
        prv2, prv1 = 0, 0

        for i in range(l, r):
            prv2, prv1 = prv1, max(prv1, prv2 + money[i])

        return prv1

    case1 = rob_range(0, n - 1)
    case2 = rob_range(1, n)
    return max(case1, case2)
