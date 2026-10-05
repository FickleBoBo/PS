def solution(rank, attendance):
    res = sorted((r, i) for i, r in enumerate(rank) if attendance[i])
    (_, a), (_, b), (_, c) = res[:3]

    return 10000 * a + 100 * b + c
