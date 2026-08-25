def solution(arr):
    lst = []
    for x in arr:
        if not lst or lst[-1] != x:
            lst.append(x)

    return lst
