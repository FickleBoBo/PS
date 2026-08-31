def solution(intStrs, k, s, l):
    res = []
    for token in intStrs:
        x = int(token[s : s + l])
        if x > k:
            res.append(x)

    return res
