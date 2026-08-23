def solution(numLog):
    ans = []
    for prv, cur in zip(numLog, numLog[1:]):
        if prv + 1 == cur:
            ans.append("w")
        elif prv - 1 == cur:
            ans.append("s")
        elif prv + 10 == cur:
            ans.append("d")
        else:
            ans.append("a")

    return "".join(ans)
