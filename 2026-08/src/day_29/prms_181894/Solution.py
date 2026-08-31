def solution(arr):
    idx = [i for i, x in enumerate(arr) if x == 2]
    if not idx:
        return [-1]
    return arr[idx[0] : idx[-1] + 1]
