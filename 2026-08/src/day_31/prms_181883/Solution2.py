from itertools import accumulate


def solution(arr, queries):
    diff = [0] * (len(arr) + 1)
    for s, e in queries:
        diff[s] += 1
        diff[e + 1] -= 1

    return [x + d for x, d in zip(arr, accumulate(diff))]
