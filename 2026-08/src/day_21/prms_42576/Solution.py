from collections import Counter


def solution(participant, completion):
    diff = Counter(participant) - Counter(completion)
    return next(iter(diff))
