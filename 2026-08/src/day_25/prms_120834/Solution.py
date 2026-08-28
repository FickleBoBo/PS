def solution(age):
    lst = []
    while age > 0:
        lst.append(chr(age % 10 + ord("a")))
        age //= 10
    lst.reverse()

    return "".join(lst)
