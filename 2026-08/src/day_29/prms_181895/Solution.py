def solution(arr, intervals):
    (s1, e1), (s2, e2) = intervals
    return arr[s1 : e1 + 1] + arr[s2 : e2 + 1]
