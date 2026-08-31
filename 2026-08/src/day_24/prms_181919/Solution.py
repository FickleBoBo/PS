def solution(n):
    ans = []
    while n > 1:
        ans.append(n)
        if n % 2:
            n = 3 * n + 1
        else:
            n //= 2
    ans.append(1)

    return ans
