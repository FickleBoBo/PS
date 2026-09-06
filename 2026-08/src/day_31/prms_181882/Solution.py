def transform(x):
    if x >= 50 and x % 2 == 0:
        return x // 2
    if x < 50 and x % 2:
        return x * 2
    return x


def solution(arr):
    return [transform(x) for x in arr]
