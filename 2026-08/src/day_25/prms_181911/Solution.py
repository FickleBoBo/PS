def solution(my_strings, parts):
    return "".join(s[a : b + 1] for s, (a, b) in zip(my_strings, parts))
