def solution(arr):
    n = len(arr)
    for i in range(n - 1):
        for j in range(i + 1, n):
            if arr[i][j] != arr[j][i]:
                return 0

    return 1
