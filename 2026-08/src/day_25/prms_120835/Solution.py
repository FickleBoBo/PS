def solution(emergency):
    n = len(emergency)
    idx = sorted(range(n), key=lambda i: emergency[i], reverse=True)

    ans = [0] * n
    for rank, i in enumerate(idx, start=1):
        ans[i] = rank

    return ans
