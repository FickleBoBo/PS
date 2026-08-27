def solution(my_string, indices):
    lst = list(my_string)
    for i in indices:
        lst[i] = "\0"

    return "".join(c for c in lst if c != "\0")
