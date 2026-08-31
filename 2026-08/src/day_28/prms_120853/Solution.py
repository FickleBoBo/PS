def solution(s):
    tokens = s.split()
    total = 0

    for i, token in enumerate(tokens):
        if token == "Z":
            total -= int(tokens[i - 1])
        else:
            total += int(token)

    return total
