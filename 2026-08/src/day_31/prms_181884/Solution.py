from itertools import accumulate


def solution(numbers, n):
    return next(s for s in accumulate(numbers) if s > n)
