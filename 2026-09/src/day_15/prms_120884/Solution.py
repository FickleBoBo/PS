def solution(chicken):
    total = 0
    x = chicken
    while x >= 10:
        total += x // 10
        x = x // 10 + x % 10

    return total
