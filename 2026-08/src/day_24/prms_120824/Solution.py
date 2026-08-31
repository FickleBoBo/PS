def solution(num_list):
    odd = sum(x % 2 for x in num_list)
    even = len(num_list) - odd
    return [even, odd]
