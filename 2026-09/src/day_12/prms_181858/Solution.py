def solution(arr, k):
    seen = set()
    ans = [-1] * k

    idx = 0
    for x in arr:
        if x in seen:
            continue
        ans[idx] = x
        seen.add(x)
        idx += 1

        if idx == k:
            break

    return ans
