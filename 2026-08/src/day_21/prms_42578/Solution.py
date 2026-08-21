import math
from collections import Counter


def solution(clothes):
    cnt = Counter(t for _, t in clothes)

    return math.prod(v + 1 for v in cnt.values()) - 1
