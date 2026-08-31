import string
from collections import deque


def solution(begin, target, words):
    words = set(words)

    q = deque([begin])
    vis = {begin}
    dist = 0

    while q:
        for _ in range(len(q)):
            cur = q.popleft()
            if cur == target:
                return dist

            for i in range(len(cur)):
                for c in string.ascii_lowercase:
                    nxt = cur[:i] + c + cur[i + 1 :]
                    if nxt not in words or nxt in vis:
                        continue

                    q.append(nxt)
                    vis.add(nxt)

        dist += 1

    return 0
