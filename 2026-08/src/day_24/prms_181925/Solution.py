from itertools import pairwise


def solution(numLog):
    res = []
    for prv, cur in pairwise(numLog):
        if prv + 1 == cur:
            res.append("w")
        elif prv - 1 == cur:
            res.append("s")
        elif prv + 10 == cur:
            res.append("d")
        else:
            res.append("a")

    return "".join(res)
