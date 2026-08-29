def solution(n):
    st = set()
    i = 1

    while i * i <= n:
        if n % i == 0:
            st.add(i)
            st.add(n // i)
        i += 1

    return sorted(st)
