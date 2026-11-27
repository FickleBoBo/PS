def solution(picture, k):
    ans = []
    for row in picture:
        line = "".join(c * k for c in row)
        ans.extend([line] * k)

    return ans
