def solution(num_list):
    cnt = 0
    for x in num_list:
        while x > 1:
            x //= 2
            cnt += 1

    return cnt
