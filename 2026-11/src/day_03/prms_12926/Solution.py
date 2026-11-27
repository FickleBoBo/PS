import string


def solution(s, n):
    lower = string.ascii_lowercase
    upper = string.ascii_uppercase
    return s.translate(str.maketrans(lower + upper, lower[n:] + lower[:n] + upper[n:] + upper[:n]))
