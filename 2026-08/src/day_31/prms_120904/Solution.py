def solution(num, k):
    idx = str(num).find(str(k))
    return idx + 1 if idx != -1 else -1
