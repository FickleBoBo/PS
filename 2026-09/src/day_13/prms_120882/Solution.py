def solution(score):
    total = [a + b for a, b in score]
    return [sum(t > x for t in total) + 1 for x in total]
