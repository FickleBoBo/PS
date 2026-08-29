from collections import Counter


def solution(s):
    cnt = Counter(s)
    return "".join(sorted(c for c, v in cnt.items() if v == 1))
