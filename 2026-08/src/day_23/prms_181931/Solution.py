def solution(a, d, included):
    return sum(a + d * i for i, inc in enumerate(included) if inc)
