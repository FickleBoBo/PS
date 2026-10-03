def has_only_0_and_5(x):
    return all(c in "05" for c in str(x))


def solution(l, r):
    ans = [x for x in range(l, r + 1) if has_only_0_and_5(x)]
    return ans if ans else [-1]
