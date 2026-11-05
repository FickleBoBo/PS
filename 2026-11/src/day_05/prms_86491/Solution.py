def solution(sizes):
    w = max(max(a, b) for a, b in sizes)
    h = max(min(a, b) for a, b in sizes)
    return w * h
