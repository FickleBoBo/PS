def solution(arr, divisor):
    ans = sorted(x for x in arr if x % divisor == 0)
    return ans if ans else [-1]
