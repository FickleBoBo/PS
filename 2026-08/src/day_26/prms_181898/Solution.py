def solution(arr, idx):
    return next((i for i in range(idx, len(arr)) if arr[i] == 1), -1)
