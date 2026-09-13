def solution(score):
    total = [a + b for a, b in score]
    return [1 + sum(t > s for t in total) for s in total]
