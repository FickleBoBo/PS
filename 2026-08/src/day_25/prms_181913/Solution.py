def solution(my_string, queries):
    lst = list(my_string)
    for a, b in queries:
        lst[a : b + 1] = lst[a : b + 1][::-1]

    return "".join(lst)
