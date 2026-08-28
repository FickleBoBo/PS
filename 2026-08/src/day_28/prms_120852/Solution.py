def solution(n):
    lst = []
    x = 2

    while n > 1:
        if n % x == 0:
            lst.append(x)
            while n % x == 0:
                n //= x
            continue

        x += 1

    return lst
