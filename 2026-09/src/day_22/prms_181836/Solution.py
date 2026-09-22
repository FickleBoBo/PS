def solution(picture, k):
    res = []
    for row in picture:
        line = "".join(c * k for c in row)
        res.extend([line] * k)

    return res
