def solution(myString, pat):
    s = "".join("B" if c == "A" else "A" for c in myString)
    return int(pat in s)
