def solution(arr, n):
    return [x + n if len(arr) % 2 != i % 2 else x for i, x in enumerate(arr)]
