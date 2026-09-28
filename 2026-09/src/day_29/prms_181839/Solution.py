def solution(a, b):
    if a % 2 and b % 2:
        return a * a + b * b
    if a % 2 or b % 2:
        return 2 * (a + b)
    return abs(a - b)
