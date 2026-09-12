def solution(arr, flag):
    res = []

    for a, f in zip(arr, flag):
        if f:
            res += [a] * (a * 2)
        else:
            del res[-a:]

    return res
