def solution(age):
    s = ""
    while age > 0:
        s += chr(age % 10 + ord("a"))
        age //= 10

    return s[::-1]
