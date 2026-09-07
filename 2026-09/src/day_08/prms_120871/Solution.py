def solution(n):
    x, cnt = 0, 0
    while cnt < n:
        x += 1
        if x % 3 == 0 or "3" in str(x):
            continue
        cnt += 1

    return x
