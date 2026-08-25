def solution(my_string, queries):
    s = list(my_string)
    for a, b in queries:
        s[a : b + 1] = s[a : b + 1][::-1]

    return "".join(s)
