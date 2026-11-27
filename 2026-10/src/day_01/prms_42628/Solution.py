import heapq


def solution(operations):
    min_pq, max_pq = [], []
    erased = [False] * len(operations)

    for i, op in enumerate(operations):
        cmd, x = op.split()
        x = int(x)

        if cmd == "I":
            heapq.heappush(min_pq, (x, i))
            heapq.heappush(max_pq, (-x, i))
        else:
            pq = max_pq if x == 1 else min_pq
            while pq and erased[pq[0][1]]:
                heapq.heappop(pq)

            if not pq:
                continue

            erased[pq[0][1]] = True
            heapq.heappop(pq)

    while min_pq and erased[min_pq[0][1]]:
        heapq.heappop(min_pq)
    while max_pq and erased[max_pq[0][1]]:
        heapq.heappop(max_pq)

    if not min_pq or not max_pq:
        return [0, 0]
    return [-max_pq[0][0], min_pq[0][0]]
