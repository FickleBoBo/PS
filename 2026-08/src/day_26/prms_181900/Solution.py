def solution(my_string, indices):
    s = list(my_string)
    for i in indices:
        s[i] = "\0"

    return "".join(c for c in s if c != "\0")
