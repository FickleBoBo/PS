def solution(arr):
    n = 1
    while n < len(arr):
        n <<= 1

    return arr + [0] * (n - len(arr))
