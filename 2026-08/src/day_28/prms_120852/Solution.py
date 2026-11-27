def solution(n):
    ans = []
    x = 2

    while n > 1:
        if n % x == 0:
            ans.append(x)
            while n % x == 0:
                n //= x

        x += 1

    return ans
