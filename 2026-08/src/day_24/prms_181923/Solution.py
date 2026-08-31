INF = 1_000_001


def solution(arr, queries):
    ans = [INF] * len(queries)

    for i, (s, e, k) in enumerate(queries):
        for j in range(s, e + 1):
            if k < arr[j] < ans[i]:
                ans[i] = arr[j]

        if ans[i] == INF:
            ans[i] = -1

    return ans
