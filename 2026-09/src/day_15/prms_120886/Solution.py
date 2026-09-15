from collections import Counter


def solution(before, after):
    return int(Counter(before) == Counter(after))
