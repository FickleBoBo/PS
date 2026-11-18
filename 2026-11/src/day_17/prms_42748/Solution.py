def solution(array, commands):
    ans = []
    for i, j, k in commands:
        tmp = sorted(array[i - 1 : j])
        ans.append(tmp[k - 1])

    return ans
