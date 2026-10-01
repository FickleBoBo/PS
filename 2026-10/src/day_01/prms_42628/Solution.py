import heapq


def solution(operations):
    min_h, max_h = [], []
    erased = [False] * len(operations)

    for i, op in enumerate(operations):
        cmd, x = op.split()
        x = int(x)

        if cmd == "I":
            heapq.heappush(min_h, (x, i))
            heapq.heappush(max_h, (-x, i))
        else:
            h = max_h if x == 1 else min_h
            while h and erased[h[0][1]]:
                heapq.heappop(h)

            if not h:
                continue

            erased[h[0][1]] = True
            heapq.heappop(h)

    while min_h and erased[min_h[0][1]]:
        heapq.heappop(min_h)
    while max_h and erased[max_h[0][1]]:
        heapq.heappop(max_h)

    if not min_h or not max_h:
        return [0, 0]
    return [-max_h[0][0], min_h[0][0]]
