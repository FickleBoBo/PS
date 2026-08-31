def solution(arr):
    res = []
    for x in arr:
        if not res or res[-1] != x:
            res.append(x)

    return res
