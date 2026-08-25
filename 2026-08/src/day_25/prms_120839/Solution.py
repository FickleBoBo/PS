def solution(rsp):
    lst = []
    for c in rsp:
        if c == "0":
            lst.append("5")
        elif c == "2":
            lst.append("0")
        else:
            lst.append("2")

    return "".join(lst)
