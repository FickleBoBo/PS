def solution(a, b):
    x = int(f"{a}{b}")
    y = int(f"{b}{a}")
    return max(x, y)
