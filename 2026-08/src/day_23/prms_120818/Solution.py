def solution(price):
    if price >= 500_000:
        return price * 80 // 100
    if price >= 300_000:
        return price * 90 // 100
    if price >= 100_000:
        return price * 95 // 100
    return price
