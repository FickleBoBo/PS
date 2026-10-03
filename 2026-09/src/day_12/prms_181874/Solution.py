import string


def solution(myString):
    src = "a" + string.ascii_uppercase[1:]
    dst = "A" + string.ascii_lowercase[1:]
    return myString.translate(str.maketrans(src, dst))
