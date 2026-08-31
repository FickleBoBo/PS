def solution(arr, query):
    for i, q in enumerate(query):
        arr = arr[q:] if i % 2 else arr[: q + 1]

    return arr
