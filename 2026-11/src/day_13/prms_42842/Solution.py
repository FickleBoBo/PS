def solution(brown, yellow):
    for h in range(3, brown):
        w = (brown + 4) // 2 - h
        if (w - 2) * (h - 2) == yellow:
            return [w, h]
