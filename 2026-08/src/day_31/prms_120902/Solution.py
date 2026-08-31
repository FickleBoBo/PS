def solution(my_string):
    return sum(map(int, my_string.replace("+ ", "").replace("- ", "-").split()))
