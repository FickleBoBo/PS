def solution(babbling):
    cnt = 0
    for s in babbling:
        for pat in ("aya", "ye", "woo", "ma"):
            s = s.replace(pat, " ")

        if not s.strip():
            cnt += 1

    return cnt
