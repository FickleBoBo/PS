def solution(numbers, direction):
    if direction == "left":
        return numbers[1:] + numbers[:1]
    else:
        return numbers[-1:] + numbers[:-1]
