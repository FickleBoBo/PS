def transform(x):
    if x >= 50 and x % 2 == 0:
        return x // 2
    if x < 50 and x % 2:
        return x * 2 + 1
    return x


def solution(arr):
    prv = arr
    cnt = 0

    while True:
        cur = [transform(x) for x in prv]
        if prv == cur:
            return cnt
        prv = cur
        cnt += 1
