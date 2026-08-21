from collections import Counter


def solution(array):
    top2 = Counter(array).most_common(2)
    if len(top2) == 1 or top2[0][1] != top2[1][1]:
        return top2[0][0]
    return -1
