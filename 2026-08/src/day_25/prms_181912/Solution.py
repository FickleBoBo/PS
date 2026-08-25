def solution(intStrs, k, s, l):
    return [int(a[s : s + l]) for a in intStrs if int(a[s : s + l]) > k]
