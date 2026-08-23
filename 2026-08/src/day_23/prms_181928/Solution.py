def solution(num_list):
    odd = even = 0

    for x in num_list:
        if x % 2:
            odd = odd * 10 + x
        else:
            even = even * 10 + x
    return odd + even
