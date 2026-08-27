def solution(n):
    lst = []
    while n > 1:
        lst.append(n)
        if n % 2 == 1:
            n = 3 * n + 1
        else:
            n //= 2
    lst.append(1)

    return lst
