def solution(score):
    total = [a + b for a, b in score]
    return [1 + sum(t > x for t in total) for x in total]
