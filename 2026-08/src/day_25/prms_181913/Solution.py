def solution(my_string, queries):
    s = list(my_string)
    for l, r in queries:
        s[l : r + 1] = s[l : r + 1][::-1]

    return "".join(s)
