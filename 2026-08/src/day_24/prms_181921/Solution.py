def func(x):
    while x > 0:
        r = x % 10
        if r != 0 and r != 5:
            return False
        x //= 10

    return True


def solution(l, r):
    ans = [x for x in range(l, r + 1) if func(x)]
    return ans if ans else [-1]
