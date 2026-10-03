def solution(s):
    total, prv = 0, 0
    for token in s.split():
        if token == "Z":
            total -= prv
        else:
            x = int(token)
            total += x
            prv = x

    return total
