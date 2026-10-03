from itertools import accumulate


def solution(numbers, n):
    return next(x for x in accumulate(numbers) if x > n)
