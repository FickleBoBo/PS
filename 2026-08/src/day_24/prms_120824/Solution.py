def solution(num_list):
    odd = sum(1 for x in num_list if x % 2 == 1)
    even = len(num_list) - odd
    return [even, odd]
