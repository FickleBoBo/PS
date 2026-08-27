def solution(numLog):
    lst = []
    for prv, cur in zip(numLog, numLog[1:]):
        if prv + 1 == cur:
            lst.append("w")
        elif prv - 1 == cur:
            lst.append("s")
        elif prv + 10 == cur:
            lst.append("d")
        else:
            lst.append("a")

    return "".join(lst)
