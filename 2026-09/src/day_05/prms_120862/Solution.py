from itertools import combinations


def solution(numbers):
    return max(a * b for a, b in combinations(numbers, 2))
