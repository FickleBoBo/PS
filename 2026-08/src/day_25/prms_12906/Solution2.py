from itertools import groupby


def solution(arr):
    return [k for k, _ in groupby(arr)]
