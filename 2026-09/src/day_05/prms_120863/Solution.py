def solution(polynomial):
    cnt = [0, 0]
    for token in polynomial.split(" + "):
        if token.endswith("x"):
            cnt[0] += int(token[:-1] or 1)
        else:
            cnt[1] += int(token)

    res = []
    if cnt[0]:
        res.append("x" if cnt[0] == 1 else f"{cnt[0]}x")
    if cnt[1]:
        res.append(str(cnt[1]))

    return " + ".join(res)
