from collections import deque


def solution(numbers, target):
    q = deque([0])

    for x in numbers:
        for _ in range(len(q)):
            cur = q.popleft()
            q.append(cur + x)
            q.append(cur - x)

    return q.count(target)
