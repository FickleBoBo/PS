from collections import Counter


def solution(strArr):
    cnt = Counter(len(s) for s in strArr)
    return max(cnt.values())
