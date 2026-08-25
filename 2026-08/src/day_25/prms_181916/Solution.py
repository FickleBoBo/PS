def solution(a, b, c, d):
    if a == b == c == d:
        return 1111 * a
    elif b == c == d:
        return (10 * b + a) ** 2
    elif c == d == a:
        return (10 * c + b) ** 2
    elif d == a == b:
        return (10 * d + c) ** 2
    elif a == b == c:
        return (10 * a + d) ** 2
    elif a == b and c == d:
        return (a + c) * abs(a - c)
    elif a == c and b == d:
        return (a + b) * abs(a - b)
    elif a == d and b == c:
        return (a + b) * abs(a - b)
    elif a == b:
        return c * d
    elif a == c:
        return b * d
    elif a == d:
        return b * c
    elif b == c:
        return a * d
    elif b == d:
        return a * c
    elif c == d:
        return a * b
    else:
        return min(a, b, c, d)
