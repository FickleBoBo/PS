def solution(intStrs, k, s, l):
    ans = []
    for int_str in intStrs:
        x = int(int_str[s : s + l])
        if x > k:
            ans.append(x)

    return ans
