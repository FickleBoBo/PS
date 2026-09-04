def solution(arr, queries):
    ans = []
    for s, e, k in queries:
        window = [x for x in arr[s : e + 1] if x > k]
        ans.append(min(window) if window else -1)

    return ans
