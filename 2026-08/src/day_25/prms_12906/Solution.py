def solution(arr):
    ans = []
    for x in arr:
        if not ans or ans[-1] != x:
            ans.append(x)

    return ans
