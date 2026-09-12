def solution(arr):
    stk = []

    for x in arr:
        if not stk or stk[-1] != x:
            stk.append(x)
        else:
            stk.pop()

    if not stk:
        return [-1]
    return stk
