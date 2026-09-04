def solution(array):
    return sum(str(x).count("7") for x in array)
