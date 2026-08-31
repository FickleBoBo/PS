def solution(arr):

    def transform(num):
        if num >= 50 and num % 2 == 0:
            return num // 2
        if num < 50 and num % 2:
            return num * 2 + 1
        return num

    prv = arr
    x = 0

    while True:
        cur = [transform(num) for num in prv]
        if prv == cur:
            return x
        prv = cur
        x += 1
