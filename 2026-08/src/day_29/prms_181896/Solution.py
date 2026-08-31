def solution(num_list):
    return next((i for i, x in enumerate(num_list) if x < 0), -1)
