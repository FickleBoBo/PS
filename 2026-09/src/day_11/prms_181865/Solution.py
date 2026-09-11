def solution(binomial):
    a, op, b = binomial.split()
    a, b = int(a), int(b)

    if op == "+":
        return a + b
    if op == "-":
        return a - b
    return a * b
