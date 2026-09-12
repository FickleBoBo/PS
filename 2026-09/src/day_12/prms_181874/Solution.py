import string


def solution(myString):
    frm = "a" + string.ascii_uppercase[1:]
    to = "A" + string.ascii_lowercase[1:]
    return myString.translate(str.maketrans(frm, to))
