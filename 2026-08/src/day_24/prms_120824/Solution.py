def solution(num_list):
    odd = sum(x % 2 for x in num_list)
    return [len(num_list) - odd, odd]
