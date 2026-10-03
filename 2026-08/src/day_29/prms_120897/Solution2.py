import math


def solution(n):
    st = set()

    for i in range(1, math.isqrt(n) + 1):
        if n % i == 0:
            st.add(i)
            st.add(n // i)

    return sorted(st)
