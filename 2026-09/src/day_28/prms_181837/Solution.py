def solution(order):
    return sum(5000 if "cafelatte" in s else 4500 for s in order)
