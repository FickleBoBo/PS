def solution(s):
    cnt = 0
    for c in s:
        if c == "(":
            cnt += 1
        else:
            if cnt == 0:
                return False
            cnt -= 1

    return cnt == 0
