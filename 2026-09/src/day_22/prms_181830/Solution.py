def solution(arr):
    n = max(len(arr), len(arr[0]))
    res = [[0] * n for _ in range(n)]
    for i, row in enumerate(arr):
        res[i][: len(row)] = row

    return res
