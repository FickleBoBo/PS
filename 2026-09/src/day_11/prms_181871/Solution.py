def solution(myString, pat):
    return sum(myString.find(pat, i) == i for i in range(len(myString)))
