from collections import Counter


def solution(lines):
    cnt = Counter()

    for s, e in lines:
        for i in range(s, e):
            cnt[i] += 1

    return sum(v >= 2 for v in cnt.values())
