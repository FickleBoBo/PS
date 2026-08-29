def solution(array, n):
    return min(array, key=lambda x: (abs(x - n), x))
