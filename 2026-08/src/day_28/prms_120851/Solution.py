def solution(my_string):
    return sum(int(c) for c in my_string if c.isdigit())
