def solution(num, total):
    a = total // num - (num - 1) // 2
    return list(range(a, a + num))
