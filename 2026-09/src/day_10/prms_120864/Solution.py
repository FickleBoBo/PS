def solution(my_string):
    s = "".join(c if c.isdigit() else " " for c in my_string)
    return sum(map(int, s.split()))
