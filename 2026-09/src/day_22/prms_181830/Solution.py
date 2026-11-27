def solution(arr):
    n = max(len(arr), len(arr[0]))
    ans = [[0] * n for _ in range(n)]
    for i, row in enumerate(arr):
        ans[i][: len(row)] = row

    return ans
