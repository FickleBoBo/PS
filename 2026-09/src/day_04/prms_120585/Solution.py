def solution(array, height):
    return sum(x > height for x in array)
