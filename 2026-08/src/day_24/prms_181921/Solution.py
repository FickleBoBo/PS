def check(x):
    return all(c in "05" for c in str(x))


def solution(l, r):
    ans = [x for x in range(l, r + 1) if check(x)]
    return ans if ans else [-1]
