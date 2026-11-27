def solution(arr, flag):
    ans = []

    for a, f in zip(arr, flag):
        if f:
            ans += [a] * (a * 2)
        else:
            del ans[-a:]

    return ans
