def solution(order):
    return sum(c in "369" for c in str(order))
