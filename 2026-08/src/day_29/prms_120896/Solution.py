from collections import Counter


def solution(s):
    cnt = Counter(s)
    return "".join(sorted(k for k, v in cnt.items() if v == 1))
