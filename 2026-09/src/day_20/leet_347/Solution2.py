from collections import Counter
from itertools import chain


class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        cnt = Counter(nums)

        n = len(nums)
        buckets = [[] for _ in range(1 + n)]
        for x, c in cnt.items():
            buckets[c].append(x)

        return list(chain.from_iterable(reversed(buckets)))[:k]
