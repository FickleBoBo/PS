def solution(a, d, included):
    return sum(a + d * i for i, flag in enumerate(included) if flag)
