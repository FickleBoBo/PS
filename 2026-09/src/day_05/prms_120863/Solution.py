def solution(polynomial):
    cnt = [0, 0]
    for s in polynomial.split(" + "):
        if s.endswith("x"):
            cnt[0] += int(s[:-1] or 1)
        else:
            cnt[1] += int(s)

    res = []
    if cnt[0]:
        res.append("x" if cnt[0] == 1 else f"{cnt[0]}x")
    if cnt[1]:
        res.append(str(cnt[1]))

    return " + ".join(res)
