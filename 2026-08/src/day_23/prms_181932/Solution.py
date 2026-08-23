def solution(code):
    ret = ""
    mode = 0

    for i, c in enumerate(code):
        if c == "1":
            mode = 1 - mode
            continue

        if i % 2 == mode:
            ret += c

    if ret:
        return ret
    return "EMPTY"
