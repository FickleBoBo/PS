def solution(n):
    if n % 2:
        k = (n + 1) // 2
        return k * k
    else:
        k = n // 2
        return 2 * k * (k + 1) * (2 * k + 1) // 3
